package leetcode.a300;

/**
 * 数字数组中最长严格连续上升的子序列
 * 是子序列而不是子数组
 * {lis},{dp}
 */
public class _300Solution {
    /**
     * dp解决方案，dp[n]可以由dp[0]...dp[n-1]确定
     * on2的时间复杂度
     * 
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        // 定义 dp[i]为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度
        // 注意 nums[i]必须被选取
        int[] count = new int[nums.length];
        for (int i = 0; i < count.length; i++) {
            count[i] = 1;
        }

        int max = 1;
        for (int i = 1; i < count.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
        }

        for (int i = 0; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }

        return max;

    }

    /**
     * 另外一种更快的dp，主要是d[i]的定义
     * d[i]表示长度为 i 的最长上升子序列的末尾元素的最小值，
     * 用 len 记录目前最长上升子序列的长度
     * d[i] 是关于 i 单调递增的
     * 在遍历nums[j]的时候，nums[j]要么>d[len],这样就发现了一个更长的上升序列
     * 要吗存在一个i<j,使得d[i-1]<nums[j]<d[i],此时d[i]可以替换成更小的nums[j]
     * {greedy}
     */
    public int lengthOfLIS2(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 找到d[i-1]<nums[j]<d[i]的i值
                // 此时d[i]的值可以替换为nums[j]，而不改变递增性质
                // 递增序列中相邻元素的性质
                int l = 1, r = len + 1;
                // 找d[]中第1个大于等于nums[i]的位置
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        // pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                d[l] = nums[i];
            }
        }
        return len;
    }
}
