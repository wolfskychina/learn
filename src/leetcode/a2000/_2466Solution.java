package leetcode.a2000;

/**
 * 可以通过往字符串后面不断添加zero个0或者one个1来构建字符串
 * 问构造出的字符串的长度在low和high之间的不同字符串有多少
 * {dp}一个爬梯子类型的题，f[i]=f[i−zero]+f[i−one] 递推关系
 */
public class _2466Solution {

    public int countGoodStrings(int low, int high, int zero, int one) {
        final int MOD = 1_000_000_007;
        int ans = 0;
        int[] f = new int[high + 1]; // f[i] 表示构造长为 i 的字符串的方案数
        f[0] = 1; // 构造空串的方案数为 1
        for (int i = 1; i <= high; i++) {
            if (i >= zero)
                f[i] = f[i - zero];
            if (i >= one)
                f[i] = (f[i] + f[i - one]) % MOD;
            if (i >= low)
                ans = (ans + f[i]) % MOD;
        }
        return ans;
    }
}
