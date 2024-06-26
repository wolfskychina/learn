package leetcode.a200;

/**
 * 反复将一个数的每一位相加，直至只剩下个位数
 * {math}
 */
public class _258Solution {
    /**
     * 每位数字之和相加的数学规律，跟除以9的余数相关
     * 取模运算满足结合律
     */
    public int addDigits(int num) {

        if (num < 10) return num;
        if (num % 9 == 0) return 9;
        return num % 9;

    }
}
