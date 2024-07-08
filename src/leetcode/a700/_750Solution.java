package leetcode.a700;

/**
 * 矩阵中，四个角是1的长方形的个数
 * 必须有四个不同的角
 */
public class _750Solution {

    /**
     * {dp},dp[i][j]为本行之前的所有行中，i和j位置都是1的行的数量
     *  @param grid
     * 
     * @return
     */
    public int countCornerRectangles(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 || n == 1)
            return 0;

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (grid[0][i] == 1 && grid[0][j] == 1) {
                    dp[i][j] = 1;
                }
            }
        }
        int total = 0;

        for (int k = 1; k < m; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {

                    if (grid[k][i] == 1 && grid[k][j] == 1) {
                        total += dp[i][j];
                        dp[i][j]++;
                    }
                }
            }
        }

        return total;

    }
}
