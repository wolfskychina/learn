package leetcode.a400;
/**
 * 对数组中的每一个数字，可以相加或者相减，问一共有多少种符号排列，使得最终的和
 * 等于target
 * 数组中每个数字都是非负整数
 * {dp}
 * TODO
 */
public class _493Solution {

    int count = 0;

    /**
     * 回溯法，遍历所有的解空间，时间复杂度为2的n次方
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {

        dfs(0, 0, target, nums);

        return count;

    }

    private void dfs(int i, int sum, int target, int[] nums) {

        if (i == nums.length) {
            if (sum == target)
                count++;
            return;
        }

        dfs(i + 1, sum + nums[i], target, nums);
        dfs(i + 1, sum - nums[i], target, nums);
    }


    /**
     * dp动态规划
     * 根据数学性质将问题转化为求子序列之和等于(sum-target)/2的数量
     * dp[i][j]为前i个元素中和为j的组合的数量
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }


}
