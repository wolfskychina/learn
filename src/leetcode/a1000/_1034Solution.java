package leetcode.a1000;

/**
 * 边界着色
 * {dfs},{matrix}
 */
public class _1034Solution {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, color, grid[row][col]);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0)
                    grid[i][j] = -grid[i][j];
            }
        }
        return grid;
    }

    public int dfs(int[][] grid, int row, int col, int colour, int gool) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return 1;
        if (grid[row][col] != gool && grid[row][col] > 0)
            return 1;
        if (grid[row][col] < 0)
            return 0;

        grid[row][col] = -grid[row][col];

        int a = 0;

        a += dfs(grid, row - 1, col, colour, gool);

        a += dfs(grid, row, col + 1, colour, gool);

        a += dfs(grid, row + 1, col, colour, gool);

        a += dfs(grid, row, col - 1, colour, gool);

        if (a != 0)
            grid[row][col] = -colour;

        return 0;
    }
}
