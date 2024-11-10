package leetcode.a2000;

/**
 * 构造最长的新字符串
 * x个AA，y个BB，z个AB拼接字符串，要求不能有连续的AAA和BBB
 * 求最多能拼接多长的字符串
 * {dp}
 */
public class _2745Solution {

    public int longestString(int x, int y, int z) {
        int[][][][] dp = new int[x + 1][y + 1][z + 1][3];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                for (int k = 0; k <= z; k++) {
                    if (i > 0) {
                        dp[i][j][k][0] = Math.max(dp[i - 1][j][k][1], dp[i - 1][j][k][2]) + 2;
                    }
                    if (j > 0) {
                        dp[i][j][k][1] = dp[i][j - 1][k][0] + 2;
                    }
                    if (k > 0) {
                        dp[i][j][k][2] = Math.max(dp[i][j][k - 1][1], dp[i][j][k - 1][2]) + 2;
                    }
                }
            }
        }
        return Math.max(Math.max(dp[x][y][z][0], dp[x][y][z][1]), dp[x][y][z][2]);
    }
}
