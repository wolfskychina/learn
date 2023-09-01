package leetcode.a400;
/**
 * 二维数组，返回(x1,y1)-(x2,y2)表示的矩形中的元素的和
 */
public class _304Solution {

    int [][] sums;

    /**
     * 将sum[x,y]定义为[0,0]-[x,y]划定的矩阵中的元素的和
     * 那么subRegin的和可以表示为
     * sum[row2,col2]-sum[row1,col2]-sum[row2,col1]+sum[row1,col1]
     * @param matrix
     */
    public _304Solution(int[][] matrix) {
        sums = new int[matrix.length][matrix[0].length];
        for(int i =0;i<sums.length;i++){
            for(int j=0;j<sums[0].length;j++){
                sums[i][j] = sums[i][j-1]+;//加上nums[i,0]-nums[i,j] 
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

    }
    
}
