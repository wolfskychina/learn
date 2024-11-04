package leetcode.a2000;

/**
 * 两排空地统计放置房子的方法数
 * {dp}类似打家劫舍问题
 */
public class _2320Solution {

    public int countHousePlacements(int n) {
        int MOD = (int) 1e9 + 7;
        int f0 = 1;
        int f1 = 1;
        for (int i = 1; i < n; i++) {
            int ff0 = (f0 + f1) % MOD;
            int ff1 = f0;
            f0 = ff0;
            f1 = ff1;
        }
        long single = (f0 + f1) % MOD;

        return (int) ((single * single) % MOD);

    }
}
