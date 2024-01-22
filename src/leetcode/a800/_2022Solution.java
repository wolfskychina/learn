package leetcode.a800;
/**
 * 一维数组转换成二维数组
 * {easy}
 */
public class _2022Solution {
   
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length!=m*n) 
            return new int[0][0];
        int res [][] = new int[m][n];

        int k=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(k<original.length)
                res[i][j] = original[k++];
            }
        }
        return res;
    }
}
