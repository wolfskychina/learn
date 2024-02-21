package leetcode.a1000;

import java.util.Arrays;

/**
 * 两枚鸡蛋掉落问题
 * n层楼往下扔鸡蛋，问最少需要多少次测试，能够保证测试出
 * 最高不会摔碎的楼层
 */
public class _1884Solution {

    /**
     * {dp}
     * dp[0][i]是用1个鸡蛋测试i层楼所需要的最少次数
     * dp[1][i]是用2个鸡蛋测试i层楼所需要的最少次数
     * 
     * @param n
     * @return
     */
    public int twoEggDrop(int n) {

        int[][] dp = new int[n + 1][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dp[0][0] = dp[1][0] = 0;
        for (int j = 1; j <= n; ++j) {
            dp[0][j] = j;
        }

        for (int j = 1; j <= n; ++j) {
            for (int k = 1; k <= j; ++k) {
                dp[1][j] = Math.min(dp[1][j], Math.max(dp[0][k - 1] + 1, dp[1][j - k] + 1));
            }
        }

        return dp[1][n];

    }

    /**
     * 压缩成一维
     * @param n
     * @return
     */
    public int twoEggDrop1(int n) {

        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int j = 1; j <= n; ++j) {
            for (int k = 1; k <= j; ++k) {
                dp[j] = Math.min(dp[j], Math.max(k, dp[j - k] + 1));
            }
        }
        return dp[n];

    }
}
