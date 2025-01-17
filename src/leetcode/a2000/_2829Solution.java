package leetcode.a2000;

/**
 * k-avoiding数组的最小总和
 * 长度为n的数组，每个元素均不相同，任意两个元素的和都不能等于k
 * 这样的数组的所有元素的最小和是多少
 * {math},{greedy}
 */
public class _2829Solution {

    /**
     * 根据贪心策略，应该从1开始逐渐变大，前面小于等于k/2的所有数都符合条件，
     * 之后k/2+1到k的所有数字都不符合条件，剩下的元素从k+1开始又符合条件
     * 前后两端数字都是等差数列
     * @param n
     * @param k
     * @return
     */
    public int minimumSum(int n, int k) {
        int m = Math.min(k / 2, n);
        return (m * (m + 1) + (k * 2 + n - m - 1) * (n - m)) / 2;
    }
}
