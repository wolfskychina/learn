package leetcode.a0;

/**
 * 实现pow(double x, int n)函数，计算n次方
 * {math}
 */
public class _50Solution {

    public double myPow(double x, int n) {

        if (n == 0)
            return 1;
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        // 提前处理Min_value的情况，防止在取反的时候
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    /**
     * 迭代的版本
     */
    double myPow2(double x, int n) {

        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1;
        while (n > 0) {
            // n为奇数的时候，需要额外乘一次x
            if ((n & 1) == 0)
                result *= x;
            x *= x;
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {

        _50Solution so = new _50Solution();
        System.out.println(so.myPow(4.0, 222));
        int min = Integer.MIN_VALUE;
        int abs = Math.abs(min);
        int negmin = -min;
        System.out.println(abs);
        System.out.println(negmin);

    }

}
