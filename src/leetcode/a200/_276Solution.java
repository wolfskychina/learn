package leetcode.a200;

/**
 * 给篱笆刷颜色，要求不能有连续的三个篱笆是相同颜色的，求一共有多少种上色方法
 * 一共有n个篱笆，和k种颜色
 * {dp}
 */
public class _276Solution {
    /**
     * 典型的dp问题，按照第n个和第n-1个篱笆的颜色是否相同来递推。
     * 如果和第n-1个篱笆的颜色不同，那么fn = fn-1 * n-1；
     * 如果和第n-1个篱笆的颜色相同，那么就必须和n-2个篱笆的颜色不同，
     * 此时fn = fn-2 * n-1；
     *
     * @param n
     * @param k
     * @return
     */
    public int numWays(int n, int k) {
        // if there are no posts, there are no ways to paint them
        if (n == 0)
            return 0;

        // if there is only one post, there are k ways to paint it
        if (n == 1)
            return k;

        // if there are only two posts, you can't make a triplet, so you
        // are free to paint however you want.
        // first post, k options. second post, k options
        if (n == 2)
            return k * k;

        int table[] = new int[n + 1];
        table[0] = 0;
        table[1] = k;
        table[2] = k * k;
        for (int i = 3; i <= n; i++) {
            // the recursive formula that we derived
            table[i] = (table[i - 1] + table[i - 2]) * (k - 1);
        }
        return table[n];
    }

    /**
     * 因为只依赖i-2和i-1的数据，所以只需要三个固定的变量即可
     */
    public int numWays2(int n, int k) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return k;
        int diffColorCounts = k * (k - 1);
        int sameColorCounts = k;
        for (int i = 2; i < n; i++) {
            int temp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * (k - 1);
            sameColorCounts = temp;
        }
        return diffColorCounts + sameColorCounts;
    }

}
