package leetcode.a800;

import java.util.Arrays;

/**
 * 跟486题一样，但是规定了石子的总和为奇数
 * 因为总和是奇数，所以能够保证先手可以赢
 * {hard},{game theory}
 */
public class _877Solution {

    private int dp[][];
    private int sum[][];

    public boolean stoneGame1(int[] piles) {
        return true;
    }

    /**
     * 和486题相同的思路
     * 让下一轮对手拿的分最少
     * 同时自底向上的缓存区间和
     * {dp}
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        sum = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        boolean res =  dfs(piles, 0, piles.length - 1) > sum[0][n - 1] / 2 ? true : false;
        return res;

    }

    private int dfs(int[] piles, int l, int r) {

        if (dp[l][r] != -1)
            return dp[l][r];
        if (l == r) {
            sum[l][r] = piles[l];
            return dp[l][r]=piles[l];
        }
        int min = Math.min(dfs(piles, l + 1, r), dfs(piles, l, r - 1));
        sum[l][r] = piles[l] + sum[l + 1][r];
        return dp[l][r] = sum[l][r] - min;

    }

    public static void main(String[] args) {
        _877Solution so = new _877Solution();
        int[] piles = { 5, 3, 4, 5 };
        so.stoneGame(piles);
    }
}
