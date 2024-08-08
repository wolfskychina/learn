package leetcode.a2000;

/**
 * 判断一个矩阵是否是一个X矩阵
 * {easy}
 */
public class _2319Solution {

    public boolean checkXMatrix(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid.length; j++) {

                if (i == j || i + j == grid.length - 1) {
                    if (grid[i][j] == 0)
                        return false;
                } else {
                    if (grid[i][j] != 0)
                        return false;
                }
            }
        }

        return true;
    }
}
