package leetcode.a800;

public class _1186Solution {

    /**
     * {dp} 自己的算法处理全是负数的时候有问题，打了补丁
     * @param arr
     * @return
     */
    public int maximumSum(int[] arr) {
        // arr = [1,-2,0,3]
        int[][] dp = new int[arr.length + 1][2];
        // dp[i][0] 没有使用减法 dp[i][1]已经使用减法
        int max = 0;
        dp[1][0] = arr[0];
        boolean allneg = true;
        int nmax = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            if (arr[i - 1] >= 0)
                allneg = false;
            nmax = Math.max(nmax, arr[i - 1]);
            dp[i][0] = Math.max(0, dp[i - 1][0] + arr[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i - 1]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        if (allneg)
            return nmax;
        return max;
    }

    /**
     * {dp}
     * @param arr
     * @return
     */
    public int maximumSum1(int[] arr) {
        int dp0 = arr[0], dp1 = 0, res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp1 = Math.max(dp0, dp1 + arr[i]);
            dp0 = Math.max(dp0, 0) + arr[i];
            res = Math.max(res, Math.max(dp0, dp1));
        }
        return res;
    }


}
