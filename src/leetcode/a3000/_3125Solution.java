package leetcode.a3000;

/**
 * 给定数字n
 * 使得所有[i,n]的数字按位与结果为0的最大数字i
 */
public class _3125Solution {

    /**
     * {math},{bit manuplation},{greedy}
     * @param n
     * @return
     */
    public long maxNumber(long n) {

        long res = 1;
        while (res <= n) {
            res <<= 1;
        }
        res >>= 1;
        return res - 1;
    }
}
