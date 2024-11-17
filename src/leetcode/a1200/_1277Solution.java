package leetcode.a1200;

/**
 * 统计全为1的正方形子矩阵的数目
 * 221变形题，和求最大正方形子矩阵类似
 * {dp}
 */
public class _1277Solution {

    /**
     * 以i，j为右下角元素的最大正方形的大小以及递推关系
     * 
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int max[][] = new int[m + 1][n + 1];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 1) {

                    max[i + 1][j + 1] = Math.min(Math.min(max[i][j + 1], max[i][j]), max[i + 1][j]) + 1;

                    res += max[i + 1][j + 1];
                }
            }
        }
        return res;
    }
}
