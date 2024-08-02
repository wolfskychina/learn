package leetcode.a3000;

/**
 * 由1作为顶点能够构成的直角三角形的数量
 * {easy}
 */
public class _3128Solution {

    public long numberOfRightTriangles(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int row[] = new int[m];
        int col[] = new int[n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1 && row[i] > 1 && col[j] > 1) {

                    res += (row[i] - 1) * (col[j] - 1);
                }
            }
        }

        return res;
    }
}
