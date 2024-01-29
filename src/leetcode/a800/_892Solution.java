package leetcode.a800;
/**
 * 三维形体的表面积
 * {easy}
 */
public class _892Solution {

    public int surfaceArea(int[][] grid) {

        int area = 0;

        for (int i = 0; i < grid.length; i++) {

            area += grid[i][0];
            area += grid[i][grid[0].length - 1];
            for (int j = 0; j < grid[0].length; j++) {

                if (j < grid[0].length - 1)
                    area += Math.abs(grid[i][j] - grid[i][j + 1]);

                if (grid[i][j] != 0)
                    area += 2;
            }
        }

        for (int j = 0; j < grid[0].length; j++) {

            area += grid[0][j];
            area += grid[grid.length - 1][j];
            for (int i = 0; i < grid.length; i++) {

                if (i < grid.length - 1)
                    area += Math.abs(grid[i][j] - grid[i + 1][j]);

            }
        }

        return area;
    }
}
