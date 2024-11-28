package leetcode.a1500;

/**
 * 子数组和为奇数的子数组的数目
 * {dp}
 */
public class _1524Solution {

    /**
     * 定义dp[2]为以i为最右侧端点的子数组的和为奇数或者偶数的数目
     * 和左侧具备递推特性
     * @param arr
     * @return
     */
    public int numOfSubarrays(int[] arr) {

        int MOD = (int) 1e9 + 7;
        int[] dp = new int[2];
        dp[0] = arr[0] % 2 == 0 ? 1 : 0;
        dp[1] = 1 - dp[0];
        int res = dp[1];
        for (int i = 1; i < arr.length; i++) {
            int dp0 = 0;
            int dp1 = 0;
            if (arr[i] % 2 == 0) {
                dp0 = dp[0] + 1;
                dp1 = dp[1];
            } else {
                dp0 = dp[1];
                dp1 = dp[0] + 1;
            }
            dp[0] = dp0;
            dp[1] = dp1;
            res = (res + dp[1]) % MOD;

        }

        return res;
    }
}
