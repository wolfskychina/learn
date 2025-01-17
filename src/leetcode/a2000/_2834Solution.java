package leetcode.a2000;

/**
 * 同2829，但是取值范围扩大，需要取模
 * {math},{greedy}
 */
public class _2834Solution {

    public int minimumPossibleSum(int n, int k) {
        long m = Math.min(k / 2, n);
        int MOD = (int) 1e9 + 7;
        return (int) ((m * (m + 1) + (k * 2L + n - m - 1) * (n - m)) / 2 % MOD);
    }
}
