package leetcode.a2000;

import java.util.Arrays;
import java.util.Stack;

/**
 * 从起点跳跃到终点的最小代价
 * 从一个点跳跃到后面某个点需要中间的节点满足两种单调栈的大小
 * {dp},{monotoic stack}
 */
public class _2297Solution {

    /**
     * 自己写的向后维护的一维dp，但是全是0的测试用例会超时
     * 
     * @param nums
     * @param costs
     * @return
     */
    public long minCost(int[] nums, int[] costs) {
        if (nums.length == 1)
            return 0;

        long[] dp = new long[nums.length];

        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        find(0, nums, costs, dp);

        return dp[dp.length - 1];
    }

    private void find(int l, int[] nums, int[] costs, long[] dp) {

        if (l == dp.length)
            return;

        int r = l + 1;
        while (r < dp.length && nums[r] >= nums[l]) {
            r++;
        }
        if (r != dp.length && dp[l] + costs[r] < dp[r]) {
            dp[r] = dp[l] + costs[r];
            find(r, nums, costs, dp);
        }
        r = l + 1;
        while (r < dp.length && nums[r] < nums[l]) {
            r++;
        }
        if (r != dp.length && dp[l] + costs[r] < dp[r]) {
            dp[r] = dp[l] + costs[r];
            find(r, nums, costs, dp);
        }
    }

    /**
     * TODO 使用两个单调栈，150ms
     * 遍历每个元素，对于每个元素，往前看栈中的元素
     * 已经出栈的元素无需再进栈
     * 假设a,b,c，b和c都是满足单调栈出栈的元素，先遇到b的时候就必须要跳跃
     * 所以是不可能满足从a直接跳到c的
     * @param nums
     * @param costs
     * @return
     */
    public long minCost2(int[] nums, int[] costs) {
        int n = nums.length;
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        Stack<Integer> maxStack = new Stack<>(), minStack = new Stack<>();
        // 对于某一个点，从栈顶开始有满足条件的全部出栈进行判断
        // 栈里面的元素一旦出栈就不再入栈,也就是说比较过一次之后（满足一次跳跃之后）
        // 以后（和后面的元素）就不会再比较了，之后的比较都是更早的元素，或者栈空后是更晚的元素
        for (int j = 0; j < n; j++) {
            while (!minStack.isEmpty() && nums[minStack.peek()] <= nums[j]) {
                int i = minStack.pop();
                dp[j] = Math.min(dp[j], dp[i] + costs[j]);
            }
            minStack.push(j);
            while (!maxStack.isEmpty() && nums[maxStack.peek()] > nums[j]) {
                dp[j] = Math.min(dp[j], dp[maxStack.pop()] + costs[j]);
            }
            maxStack.push(j);
        }
        return dp[n - 1];
    }

    /**
     * 用数组模拟两个单调栈，速度最快，14ms
     * 
     * @param nums
     * @param costs
     * @return
     */
    public long minCost1(int[] nums, int[] costs) {
        int n = nums.length;
        long[] dp = new long[n];

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + costs[i];

            int lt = nums[i - 1];
            for (int j = i - 2; j >= 0; j--) {
                if (nums[j] <= nums[i] && nums[j] > lt) {
                    dp[i] = Math.min(dp[i], dp[j] + costs[i]);
                }
                if (nums[j] >= nums[i]) {
                    break;
                } else {
                    lt = Math.max(lt, nums[j]);
                }
            }

            int gt = nums[i - 1];
            for (int j = i - 2; j >= 0; j--) {
                if (nums[j] > nums[i] && gt >= nums[j]) {
                    dp[i] = Math.min(dp[i], dp[j] + costs[i]);
                }
                if (nums[j] <= nums[i]) {
                    break;
                } else {
                    gt = Math.min(gt, nums[j]);
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        _2297Solution so = new _2297Solution();
        int nums[] = { 3, 2, 4, 4, 1 };
        int costs[] = { 3, 7, 6, 4, 2 };
        so.minCost(nums, costs);
    }
}
