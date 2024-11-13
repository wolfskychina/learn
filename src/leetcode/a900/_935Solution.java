package leetcode.a900;

import java.util.Arrays;

/**
 * 电话拨号键盘，只能按照马的走字到下一个位置
 * 求按N个数字之后总共能产生多少不同的数字排列
 */
public class _935Solution {

    /**
     * 找规律，每个数字后继数字是固定的
     * 因此是不同状态下的切换，可以使用滚动数组
     * {dp}
     * @param N
     * @return
     */
    public int knightDialer(int N) {
        int MOD = 1_000_000_007;
        // 每个数字对应的下一个的位置
        int[][] moves = new int[][] {
                { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 3, 9, 0 },
                {}, { 1, 7, 0 }, { 2, 6 }, { 1, 3 }, { 2, 4 } };

        int[][] dp = new int[2][10];
        Arrays.fill(dp[0], 1);
        for (int hops = 0; hops < N - 1; ++hops) {
            Arrays.fill(dp[~hops & 1], 0);
            for (int node = 0; node < 10; ++node)
                for (int nei : moves[node]) {
                    dp[~hops & 1][nei] += dp[hops & 1][node];
                    dp[~hops & 1][nei] %= MOD;
                }
        }

        long ans = 0;
        for (int x : dp[~N & 1])
            ans += x;
        return (int) (ans % MOD);
    }
}
