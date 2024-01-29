package leetcode.a800;

/**
 * 三维形体到三个坐标平面的投影面积
 */
public class _883Solution {

    public int projectionArea(int[][] grid) {

        int area = 0;

        for (int i = 0; i < grid.length; i++) {

            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, grid[i][j]);
                // 注意到xy平面的面积，需要判断(i,j)坐标的高度，不一定是m*n的面积
                if (grid[i][j] != 0)
                    area++;
            }
            area += max;
        }

        for (int j = 0; j < grid[0].length; j++) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                max = Math.max(max, grid[i][j]);
            }
            area += max;
        }

        return area;

    }
}
