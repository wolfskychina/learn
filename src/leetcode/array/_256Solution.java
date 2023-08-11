package leetcode.array;
/**
 * 刷房子，每个房子刷成不同颜色的成本均不相同，并且相邻房子不能刷成同一个颜色
 * 求能满足要求的全部刷完的成本是多少
 */
public class _256Solution {

    /**
     * 明显的dp问题
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        int dp[][] = new int[n][3];

        for(int i =0;i<n;i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
            dp[i][2] = Integer.MAX_VALUE;
        }

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i =1;i<n;i++){

            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+costs[i][2];
        }

        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
        
    } 
}
