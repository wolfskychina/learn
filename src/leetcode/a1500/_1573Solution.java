package leetcode.a1500;

/**
 * 分割二进制字符成三段，每段包含的1相同的方案数
 * {math}
 */
public class _1573Solution {

    /**
     * 组合数学，但是特别容易溢出
     * @param s
     * @return
     */
    public int numWays(String s) {
        int MOD = (int) 1e9 + 7;
        int num1 = 0;
        for (char c : s.toCharArray()) {

            if (c == '1')
                num1++;
        }

        if (num1 % 3 != 0)
            return 0;
        if (num1 == 0)
            return (int) ((((long) s.length() - 1) * ((long) s.length() - 2) / 2) % MOD);
        char[] ss = s.toCharArray();
        int i = 0;
        int count = num1 / 3;
        while (count > 0) {
            if (ss[i++] == '1') {
                count--;
            }
        }
        int count1 = 0;
        while (ss[i] == '0') {
            count1++;
            i++;
        }
        count = num1 / 3;
        while (count > 0) {
            if (ss[i++] == '1') {
                count--;
            }
        }
        int count2 = 0;
        while (ss[i] == '0') {
            count2++;
            i++;
        }

        // TODO 整数相乘的时候要先转换成long，否则计算中会按照int计算，最后才会转换
        long res = (((long) count1 + 1) % MOD) * (((long) count2 + 1) % MOD) % MOD;
        res = res % MOD;
        return (int) res;
    }
}
