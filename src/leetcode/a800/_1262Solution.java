package leetcode.a800;
/**
 * 数组中任意元素的组合的和，能被3整除的最大值
 */
public class _1262Solution {

    /**
     * dp[i][j]表示，前i个元素中的任意组合的和，被3整除分别为0.1,2时的最大值
     * {dp}
     * @param nums
     * @return
     */
    public int maxSumDivThree(int[] nums) {

        int dp[] = new int[3];
        // 注意dp[0][1]和dp[0][2]是没有选取元素时，不可能的余数情况
        // 不能从dp[1]和dp[2]开始递推，只能从dp[0]开始递推
        dp[1] = Integer.MIN_VALUE;
        dp[2] = Integer.MIN_VALUE;

        for (int i = 1; i <= nums.length; i++) {

            int dp0 = dp[0];
            int dp1 = dp[1];
            int dp2 = dp[2];
            int j = nums[i - 1] % 3;
            if (j == 0) {
                dp0 += nums[i - 1];
                dp1 += nums[i - 1];
                dp2 += nums[i - 1];
            } else if (j == 1) {
                dp0 = Math.max(dp[0], dp[2] + nums[i - 1]);
                dp1 = Math.max(dp[1], dp[0] + nums[i - 1]);
                dp2 = Math.max(dp[2], dp[1] + nums[i - 1]);
            } else {
                dp0 = Math.max(dp[0], dp[1] + nums[i - 1]);
                dp1 = Math.max(dp[1], dp[2] + nums[i - 1]);
                dp2 = Math.max(dp[2], dp[0] + nums[i - 1]);
            }

            dp[0] = dp0;
            dp[1] = dp1;
            dp[2] = dp2;

        }

        return dp[0];
    }
}
