package leetcode.a1000;

/**
 * 石头对对碰，最后剩下的石头的最小重量是多少
 */
public class _1049Solution {

    /**
     * 石头分成两组，重量最近
     * 背包问题
     * {dp}
     * dp[i][j] 为前i个石头总和不超过j的最大值
     * 
     * @param ss
     * @return
     */
    public int lastStoneWeightII(int[] ss) {
        int n = ss.length;
        int sum = 0;
        for (int i : ss)
            sum += i;
        int t = sum / 2;
        int[] f = new int[t + 1];
        for (int i = 1; i <= n; i++) {
            int x = ss[i - 1];
            for (int j = t; j >= x; j--) {
                f[j] = Math.max(f[j], f[j - x] + x);
            }
        }
        return Math.abs(sum - f[t] - f[t]);

    }

    int res = Integer.MAX_VALUE;

    /**
     * {dfs}
     * @param stones
     * @return
     */
    public int lastStoneWeightII1(int[] stones) {
        //尽可能的把石头分成和相同的两部分
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        dfs( sum / 2,stones, 0);
        //找的是最小的差值，用的只是一半的值
        return res * 2 + sum % 2;
    }

    public void dfs(int target, int[] stones, int idx) {
        res = Math.min(res, target);
    
        //res = 0说明已经找到了一半值
        for (int i = idx; i < stones.length && res != 0; i++) {
            if (target - stones[i] >= 0)
                dfs(target - stones[i], stones, i + 1);
        }
    }
}
