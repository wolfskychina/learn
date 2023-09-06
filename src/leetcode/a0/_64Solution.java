package leetcode.a0;


public class _64Solution {

    public int minPathSum(int[][] grid) {

        int width = grid[0].length;
        int[] dp = new int[width];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<width;j++){
                if(j==0){
                    dp[j]+=grid[i][j];
                }else if(i==0){
                    dp[j]=dp[j-1]+grid[i][j];
                }else {
                    dp[j] = Math.min(dp[j],dp[j-1]) +grid[i][j];
                }

            }

        }
        return dp[width-1];
    }

    public static void main(String [] args){
        _64Solution so = new _64Solution();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        so.minPathSum(grid);
    }
}
