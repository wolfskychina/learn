package leetcode.a2000;

import java.util.Arrays;

/**
 * 购买物品的最大开销
 * {greedy},{sorting}
 */
public class _2931Solution {

    public long maxSpending(int[][] values) {
        int m = values.length;
        int n = values[0].length;
        int[] a = new int[m * n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(values[i], 0, a, i * n, n);
        }
        Arrays.sort(a);

        long ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans += (long) a[i] * (i + 1);
        }
        return ans;
    }
}
