package leetcode.a800;
/**
 * 检查一个数独是否合法
 * {easy}
 */
public class _2133Solution {
   
    public boolean checkValid(int[][] matrix) {

        for(int i=0;i<matrix.length;i++){
            int[] checkRow = new int[matrix.length];
            int [] checkCol = new int[matrix.length];
            for(int j=0;j<matrix.length;j++){
                checkRow[matrix[i][j]-1]=1;
                checkCol[matrix[j][i]-1]=1;
            }

            for(int k=0;k<matrix.length;k++){
                if(checkCol[k]!=1||checkRow[k]!=1)
                    return false;
            }

        }

        return true;
    }
}
