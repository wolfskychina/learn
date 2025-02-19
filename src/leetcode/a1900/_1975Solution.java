package leetcode.a1900;

/**
 * 最大方阵和
 * 每次允许对任意相邻得两个格子都*-1
 * 求经过任意次运算后所能得到得最大方阵元素之和、
 * {brain teaser},{easy}
 */
public class _1975Solution {

    /**
     * 如果两个相邻格子都是负得，可以直接变成正得
     * 如果有一个格子是负值，那么每次操作可以让负值移动到另外一个格子
     * 所以负值可以移动到任意一个格子，直到两两抵消
     * 最后是否有剩余得负值只依赖矩阵中原始负值得个数
     * @param matrix
     * @return
     */
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int numNeg = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] < 0) {
                    numNeg++;
                    matrix[i][j] = -matrix[i][j];
                }

                sum += matrix[i][j];
                min = Math.min(min, matrix[i][j]);
            }
        }
        return numNeg % 2 == 0 ? sum : sum - 2 * min;
    }
}
