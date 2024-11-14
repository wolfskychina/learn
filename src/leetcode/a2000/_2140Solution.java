package leetcode.a2000;

/**
 * 解决智力问题
 * 每个题可以选择做或者不做，做了可以拿分，但是之后x轮不能做题
 * 求能够拿到的最大分数
 * {dp},{hard},{reverse thinking}
 */
public class _2140Solution {

    /**
     * 逆向思维，从后往前接续
     * @param questions
     * @return
     */
    public long mostPoints(int[][] questions) {

        int len = questions.length;

        // dp[i]表示 遇到第i个题所能得的分
        long[] dp = new long[len + 1];

        // 从后往前
        for (int i = len - 1; i >= 0; i--) {
            // 如果当前题的下一跳在范围内能做的话
            if (i + questions[i][1] + 1 < len) {
                // max(不做这题，判断下一题所得的分(下一题不一定做不做)，
                // 或者 做这题+判断下一跳题所得的分（下一跳题不一定做不做），中间的题的分数就都拿不到了)
                dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[i + questions[i][1] + 1]);
            } else {
                // 下一跳不在范围内了，直接比较 做当前题还是下一题所得的分
                dp[i] = Math.max(dp[i + 1], questions[i][0]);
            }
        }
        return dp[0];
    }
}
