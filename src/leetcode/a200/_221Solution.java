package leetcode.a200;

/**
 * 求一个方形矩阵中，最大的全部由1组成的正方形
 * {dp}
 */
public class _221Solution {
  // dp问题，关键是dp[i][j]的定义
  // dp[i][j]为以i，j节点为最右下脚元素的所有正方形中，全部为1的正方形的最大边长
  public int maximalSquare(char[][] a) {
    if (a == null || a.length == 0 || a[0].length == 0)
      return 0;

    int max = 0, n = a.length, m = a[0].length;

    // dp(i, j) represents the length of the square
    // whose lower-right corner is located at (i, j)
    // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
    int[][] dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (a[i - 1][j - 1] == '1') {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
          max = Math.max(max, dp[i][j]);
        }
      }
    }

    // return the area
    return max * max;
  }

}
