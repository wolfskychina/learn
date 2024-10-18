package leetcode.a1200;
/**
 * 统计被水完全包围的岛屿的数量
 * 注意可能有岛屿套岛屿的情况
 */
public class _1254Solution {

    /**
     * 先把边缘的岛屿全部去掉，然后再遍历
     * {dfs}
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {

        // side 0 to 1
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                changeZeroToOne(grid, i, 0);
            }
            if (grid[i][grid[0].length - 1] == 0) {
                changeZeroToOne(grid, i, grid[0].length - 1);
            }
        }

        for (int j = 1; j < grid[0].length - 1; j++) {
            if (grid[0][j] == 0)
                changeZeroToOne(grid, 0, j);
            if (grid[grid.length - 1][j] == 0)
                changeZeroToOne(grid, grid.length - 1, j);
        }

        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    changeZeroToOne(grid, i, j);
                }
            }
        }
        return count;
    }

    private static int[][] step = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private void changeZeroToOne(int[][] grid, int i, int j) {

        if (valid(grid, i, j)) {
            grid[i][j] = 1;

            for (int k = 0; k <= 3; k++) {
                int x = i + step[k][0];
                int y = j + step[k][1];
                changeZeroToOne(grid, x, y);
            }
        }
    }

    private boolean valid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 0;
    }
}
