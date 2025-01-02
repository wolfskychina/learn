package leetcode.a1900;

/**
 * 统计n位数字字符串的组成中，满足偶数位都是偶数
 * 奇数位均为质数的组成的数目
 * 可以有前导0
 * {math},{big integer}
 */
public class _1922Solution {

    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        int N = (int) Math.pow(10, 9) + 7;
        // 如果是奇数,还得乘个5
        int cheng = 1;
        if (n % 2 == 1) {
            cheng = 5;
        }
        // n中有多少个偶数
        long o = n / 2;
        // 4*5 的 偶数 次方
        long a = pow(20, o);

        long ans = a * cheng;
        return (int) (ans % N);
    }

    /**
     * 快速幂计算
     * 
     * @param x
     * @param n
     * @return
     */
    private long pow(long x, long n) {
        // 确保所有计算等式两边都必须有long类型保证精度
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
        }
        return res;
    }
}
