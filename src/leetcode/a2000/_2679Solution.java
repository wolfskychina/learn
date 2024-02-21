package leetcode.a2000;

import java.util.Arrays;
/**
 * {easy},同2500题
 */
public class _2679Solution {
   
    public int matrixSum(int[][] grid) {
        int res = 0;
        for(int[] row:grid){
            Arrays.sort(row);
        }

        for(int i=0;i<grid[0].length;i++){
            int max =0;
            for(int j=0;j<grid.length;j++){
                max = Math.max(max,grid[j][i]);
            }
            res+=max;
        }
        return res;
    }
}
