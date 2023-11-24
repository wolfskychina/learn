package leetcode.a600;

/**
 * 岛屿的最大面积
 */
public class _695Solution {

    int max = 0;

    public int maxAreaOfIsland(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, visit(grid, i, j));
                }
            }
        }

        return max;

    }

    private int[][] step = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private int visit(int[][] grid, int i, int j) {
        int res = 0;
        if (valid(grid, i, j)) {
            grid[i][j] = 0;
            res++;
            for (int k = 0; k < step.length; k++) {
                int xx = i + step[k][0];
                int yy = j + step[k][1];
                res += visit(grid, xx, yy);
            }
            return res;
        } else {
            return 0;
        }
    }

    private boolean valid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1;
    }
}
