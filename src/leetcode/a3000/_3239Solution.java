package leetcode.a3000;

/**
 * 最少反转次数使得二进制矩阵符合按照行或者列回文
 * 
 */
public class _3239Solution {

    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int rowCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                rowCount += grid[i][j] ^ grid[i][n - 1 - j];
            }
        }
        int columnCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                columnCount += grid[j][i] ^ grid[m - 1 - j][i];
            }
        }
        return Math.min(rowCount, columnCount);
    }
}
