package leetcode.a3000;
/**
 * 修改矩阵的值
 * {easy}
 */
public class _3033Solution {
   
    public int[][] modifiedMatrix(int[][] matrix) {

        for(int i=0;i<matrix[0].length;i++){

            int max = -1;
            for(int j=0;j<matrix.length;j++){
                max = Math.max(max,matrix[j][i]);
            }
            for(int j=0;j<matrix.length;j++){
                if(matrix[j][i]==-1)
                    matrix[j][i] = max;
            }
        }
        return matrix;
    }
}
