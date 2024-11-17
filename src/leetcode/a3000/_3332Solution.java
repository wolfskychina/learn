package leetcode.a3000;

/**
 * 旅客能够得到的最大分数
 * 每天呆在原城市和去不同的城市会得到不同的分数
 * {dp},{easy}
 */
public class _3332Solution {

    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {

        int dp[][] = new int[k + 1][n];
        for (int i = 1; i < k + 1; i++) {

            for (int j = 0; j < n; j++) {

                for (int m = 0; m < n; m++) {

                    if (m == j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + stayScore[i - 1][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][m] + travelScore[m][j]);
                    }
                }
            }
        }
        int max = 0;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, dp[k][j]);
        }
        return max;
    }
}
