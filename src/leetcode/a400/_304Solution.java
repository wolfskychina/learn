package leetcode.a400;

/**
 * 二维数组，返回(x1,y1)-(x2,y2)表示的矩形中的元素的和
 */
public class _304Solution {

    int[][] sums;

    /**
     * 将sum[x,y]定义为[0,0]-[x,y]划定的矩阵中的元素的和
     * 那么subRegin的和可以表示为
     * sum[row2,col2]-sum[row1,col2]-sum[row2,col1]+sum[row1,col1]
     * 
     * @param matrix
     */
    public _304Solution(int[][] matrix) {
        sums = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < sums.length; i++) {
            for (int j = 0; j < sums[0].length; j++) {
                sums[i][j] = matrix[i][j] - ((i > 0 && j > 0) ? sums[i - 1][j - 1] : 0)
                        + (i > 0 ? sums[i - 1][j] : 0) + (j > 0 ? sums[i][j-1] : 0);

            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return sums[row2][col2] - (row1 > 0 ? sums[row1 - 1][col2] : 0) - (col1 > 0 ? sums[row2][col1 - 1] : 0)
                + ((row1 > 0 && col1 > 0) ? sums[row1 - 1][col1 - 1] : 0);

    }

    public static void main(String[] args){
        int[][] input = {{1,1,1},{1,1,1},{1,1,1}};
        _304Solution so = new _304Solution(input);
        so.sumRegion(1, 1, 2, 2);

    }

}
