package leetcode.a300;
/**
 * a的超级大的次数的幂，次数b用数组表示，最终结果mod1337
 */
public class _372Solution {

    static final int MOD = 1337;

    /**
     * 将b拆成10的i次方加bj的和的形式
     * 根据幂的结合律进行分拆，
     * @param a
     * @param b
     * @return
     */
    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow(a, b[i]) % MOD);
            a = pow(a, 10);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;

        while (n != 0) {
            // 奇数的话需要多乘一次x
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }

}
