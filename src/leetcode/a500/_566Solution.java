package leetcode.a500;

/**
 * 将矩阵中的元素填充到另外一个矩阵中
 * 如果矩阵大小不相同，返回原矩阵
 * {easy}
 */
public class _566Solution {

    /**
     * {matrix traverse}
     * 
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c)
            return mat;
        int res[][] = new int[r][c];
        int k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = mat[k / n][k % n];
                k++;
            }
        }
        return res;
    }
}
