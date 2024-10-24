package leetcode.a1600;

/**
 * 按照字符串方式拼接从1到n的二进制数，返回整数形式
 */
public class _1680Solution {

    private static final int MOD = 1000000007;

    public int concatenatedBinary(int n) {
        int res = 0, shift = 0;
        for (int i = 1; i <= n; i++) {
            // 计算需要左移多少位
            if ((i & (i - 1)) == 0) {
                // 说明是2的幂，需要比上次多移1位
                shift++;
            }
            // 如果不是2的幂，则和上次左移的位数相同,shift不变
            res = (int) ((((long) res << shift) + i) % MOD);
        }
        return res;
    }
}
