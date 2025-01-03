package leetcode.a600;

/**
 * 1-n的序列中，完全错位排列的数量
 */
public class _634Solution {

    /**
     * fn为1-n的序列中错位排列的数量
     * 那么fn只能通过两种情况从1-（n-1）的序列中产生
     * 1是从1-（n-1）的所有乱排列中，将每一位放到第n位，原来位置由n代替，共有fn-1 * n-1种
     * 2是从1-（n-1）的排列中满足只有1位在原位，其他n-2位都在错位位置上的排列，这种排列共有fn-2*n-1种，将
     * 这种排列中的原位位置的数放到n位置，将n放到原位置得到，共有fn-2*n-1
     * 综合1和2，共有fn = （fn-1 + fn-2)*(n-1)中方法
     * {dp},{combination},{math}
     * @param n
     * @return
     */
    public int findDerangement(int n) {
        if (n < 2)
            return 0;

        long f2 = 1;
        long f1 = 0;
        for (int i = 3; i <= n; i++) {
            long f = ((f2 + f1) * (i - 1)) % 1000000007;
            f1 = f2;
            f2 = f;
        }
        return (int) f2;

    }

}
