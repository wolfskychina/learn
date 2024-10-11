package leetcode.a1000;

/**
 * 飞地的数量
 * 跟边缘接壤的土地不算飞地
 * {matrix},{dfs},{easy}
 */
public class _1020Solution {

    int res = 0;

    public int numEnclaves(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[0][j] != 0) {
                    dfs(grid, 0, j);
                }
                if (grid[grid.length - 1][j] != 0) {
                    dfs(grid, grid.length - 1, j);
                }
                if (grid[i][0] != 0)
                    dfs(grid, i, 0);
                if (grid[i][grid[0].length - 1] != 0)
                    dfs(grid, i, grid[0].length - 1);
            }
        }
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {

                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }

        return res;

    }

    private void dfs(int[][] grid, int x, int y) {

        if (!valid(grid, x, y)) {
            return;
        }

        grid[x][y] = 0;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    private boolean valid(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0)
            return false;
        return true;
    }
}
