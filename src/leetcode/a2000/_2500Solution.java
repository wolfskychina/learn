package leetcode.a2000;

import java.util.Arrays;
/**
 * 每次删除每一行中的最大值
 * {easy}
 */
public class _2500Solution {
   
    public int deleteGreatestValue(int[][] grid) {
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
