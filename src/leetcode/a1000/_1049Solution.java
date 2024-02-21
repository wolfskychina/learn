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
     * @param ss
     * @return
     */
    public int lastStoneWeightII(int[] ss) {
        int n = ss.length;
        int sum = 0;
        for (int i : ss) sum += i;
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
}
