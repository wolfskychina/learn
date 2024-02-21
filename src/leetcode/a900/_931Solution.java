package leetcode.a900;
/**
 * 下降路径最小和
 */
public class _931Solution {

    /**
     * {dp} 经典dp
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix[0].length;
        int m = matrix.length;

        int dp[] = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = matrix[0][i];
        }

        for (int i = 1; i < m; i++) {

            int dpp[] = new int[n];
            dpp[0] = Math.min(dp[0], dp[1]) + matrix[i][0];
            dpp[n - 1] = Math.min(dp[n - 1], dp[n - 2]) + matrix[i][n - 1];
            for (int j = 1; j < n - 1; j++) {
                dpp[j] = Math.min(Math.min(dp[j - 1], dp[j]), dp[j + 1]) + matrix[i][j];
            }

            dp = dpp;
        }

        int res = Integer.MAX_VALUE;
        for (int i : dp) {
            res = Math.min(res, i);
        }

        return res;
    }
}
