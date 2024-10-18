package leetcode.a1300;
/**
 * 有序矩阵中的负数的数量
 * {easy}
 */
public class _1351Solution {
   
    public int countNegatives(int[][] grid) {
        int res =0;
        int j=grid[0].length-1;
        for(int i=0;i<grid.length;i++){

            while(j>=0&&grid[i][j]<0) j--;
            res+=grid[0].length-1-j;

        }
        return res;
    }
}
