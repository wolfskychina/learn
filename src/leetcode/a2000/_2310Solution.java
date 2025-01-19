package leetcode.a2000;

/**
 * 个位数为k的任意整数之和等于num，问满足条件的最少这种数的个数
 * 如果不能满足条件返回-1
 * {math}
 */
public class _2310Solution {

    /**
     * 只要这些数的个位数的乘积和num同余且这些个位数之和不超过num即可
     * @param num
     * @param k
     * @return
     */
    public int minimumNumbers(int num, int k) {

        if (num == 0)
            return 0;
        if (num % 10 == 0 && k == 0)
            return 1;
        if (k == 0)
            return -1;
        for (int i = 1; i <= 10; i++) {
            if ((k * i % 10 == num % 10) && (k * i <= num)) {
                return i;
            }
        }
        return -1;
    }
}
