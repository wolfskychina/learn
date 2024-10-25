package leetcode.a3000;

import java.util.Arrays;

/**
 * 执行操作能获得的最大value
 * 如果之前累计的value之和不超过当前数，那么当前数可以累加到总的value上
 */
public class _3180Solution {

    /**
     * {dp}
     * 对所有可能得到的value解空间进行遍历
     * 
     * @param rewardValues
     * @return
     */
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int m = rewardValues[rewardValues.length - 1];
        // 因为之前累加的和不能超过当前数
        // 所以最后最大值也不可能等于2*m
        int[] dp = new int[2 * m];
        dp[0] = 1;
        for (int x : rewardValues) {
            // k作为和的可能解空间大小受到x值的制约
            for (int k = 2 * x - 1; k >= x; k--) {
                if (dp[k - x] == 1) {
                    dp[k] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 1) {
                res = i;
            }
        }
        return res;
    }
}
