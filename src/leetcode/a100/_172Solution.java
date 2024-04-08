package leetcode.a100;

/**
 * 整数的阶乘末尾有多少个零
 */
public class _172Solution {

    public int trailingZeroes(int n) {

        int i = 1;
        int sum = 0;

        while (Math.pow(5, i) <= n) {
            double sub = Math.pow(5, i);

            sum += n / sub;
            i++;
        }

        return sum;
    }
}
