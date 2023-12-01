package leetcode.a700;
/**
 * 判断一个矩阵是不是Toeplitz Matrix
 */
public class _766Solution {

    /**
     * {easy}
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {

        for (int i = 0; i < matrix[0].length; i++) {

            if (!valid(0, i, matrix))
                return false;
        }

        for (int i = 1; i < matrix.length; i++) {

            if (!valid(i, 0, matrix))
                return false;
        }

        return true;
    }

    private boolean valid(int i, int j, int[][] matrix) {

        int val = matrix[i][j];
        i++;
        j++;
        while (i < matrix.length && j < matrix[0].length) {
            if (matrix[i][j] != val)
                return false;
            i++;
            j++;
        }
        return true;
    }

}
