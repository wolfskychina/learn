package leetcode.a2000;

/**
 * 美丽整数的最小增量
 * 将n最少增大多少之后能够使得各位数字之和小于或者等于target
 * TODO 如果题目要求最后各位数字之和大于target呢？
 * {math},{greedy}
 */
public class _2457Solution {

    /**
     * 贪心规则，从最小位开始增加，只有产生进位n的各位数字之和才有可能减小
     * 
     * @param n
     * @param target
     * @return
     */
    public long makeIntegerBeautiful(long n, int target) {

        if (getSum(n) <= target)
            return 0;

        long mod = 10L, res = 0L;

        while (getSum(n) > target) {
            // 本次对从右往左第mod-1位产生进位所需要增加的值t
            long t = mod - n % mod;
            res += t;
            n += t;
            mod *= 10;
        }

        return res;

    }

    /** 求数位和 */
    private int getSum(long n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}
