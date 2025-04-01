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
     * 很难想到，什么情况下才能从后向前思考呢
     * 从后面往前想，特别违反直觉，最后dp[0]是最大的总得分
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

    /**
     * 自己的错误的正向做法
     * @param q
     * @return
     */
    public long mostPoints1(int[][] q) {
        int n = q.length;
        long[] f = new long[n + 1];
        for (int i = 0;i<n;i++) {
            
            f[i+1] = Math.max(f[i+1],f[i]);
            // 跟下面的正向做法的差异只有if判断条件
            // 这样做会导致有的点选中的话会直接跳到最后一个节点的末尾之后的情况下
            // 的得分无法保存，应该跟最终得分进行比较，有可能比最终得分高，需要更新最高得分
            if(i+1+q[i][1]<f.length){
                f[i+1+q[i][1]] = Math.max(f[i+1+q[i][1]],f[i]+q[i][0]);
            }

        }
        return f[n];
    }
    
    public long mostPoints2(int[][] questions) {
        int n = questions.length;
        long[] f = new long[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = Math.max(f[i + 1], f[i]);
            int[] q = questions[i];
            // 因为要返回最后一个节点的值，所以最后一个节点的值也要保存
            // 中途最大值
            // 即使某一次选了之后下一跳超出了n，那么这次选中后获得的总分
            // 也要和n的值进行比较。
            // n的值为兜底值
            int j = Math.min(i + q[1] + 1, n);
            f[j] = Math.max(f[j], f[i] + q[0]);
        }
        return f[n];
    }
}
