package leetcode.a2000;

/**
 * 矩阵中的局部最大值
 * {easy}
 */
public class _2373Solution {

    private static int[][] step = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 }, { 0, 1 },
            { 0, -1 } };

    public int[][] largestLocal(int[][] grid) {

        int[][] res = new int[grid.length - 2][grid.length - 2];

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {

                int x = i + 1;
                int y = j + 1;
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < 9; k++) {
                    int xx = x + step[k][0];
                    int yy = y + step[k][1];
                    max = Math.max(max, grid[xx][yy]);
                }
                res[i][j] = max;
            }
        }

        return res;
    }
}
