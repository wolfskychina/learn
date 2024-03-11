package leetcode.a800;
/**
 * 从四个方向上保持城市天际线的前提下
 * 所有建筑还能升高的总和
 * {greedy}
 */
public class _807Solution {

    /**
     * 实际上只需要计算两个方向的天际线
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int row[] = new int[grid.length];
        int col[] = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid.length; j++) {

                row[i] = Math.max(row[i], grid[i][j]);
                col[i] = Math.max(col[i], grid[j][i]);
            }
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid.length; j++) {

                count += Math.min(row[i], col[j]) - grid[i][j];
            }
        }

        return count;

    }
}
