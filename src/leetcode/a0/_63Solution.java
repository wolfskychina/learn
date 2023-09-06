package leetcode.a0;
/**
 * 带有障碍格子的棋盘最多有多少种路径
 */
public class _63Solution {

    public int uniquePathswithObstacles(int[][] obstacleGrid){
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for(int [] row:obstacleGrid){
            for(int j = 0; j<width; j++){
                if(row[j]==1){
                    dp[j] = 0;
                }else if(j>0){
                    dp[j] += dp[j];
                }
            }
        }

        return dp[width-1];
    }
}
