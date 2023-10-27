package leetcode.a400;

import java.util.Arrays;

/**
 * 一行正整数数列，两人轮流从两端取一张牌加到自己的总分数上
 * 问能否保证先抽牌的人一定能赢？
 * 假设两人都按照有利于自己的策略去抽牌。
 */
public class _486Solution {

    int[][] dp = new int[21][21];

    /**
     * 零和博弈，两人能够拿到的总分的和是一定的
     * 一个人多，那么另外一个人拿到的必定少
     * 这种情况下存在先发者优势，
     * 即先发的人有主动权让后发的人的下一轮拿到最低的分数
     * 先发策略：不去看本轮能拿多少分，而是让对手下一轮拿分最少
     * 这种策略能够保证对方分数尽可能少，但是是否一定能赢还要看最终的分数
     * @param nums
     * @param L
     * @param R
     * @return
     */
    public int sum(int[] nums, int L, int R) {

        int sum = 0;
        for (int i = L; i <= R; i++) {
            sum += nums[i - 1];
        }
        return sum;
    }

    public int dfs(int L, int R, int[] nums) {
        if (dp[L][R] != -1) {
            return dp[L][R];
        }
        if (L == R) {
            return dp[L][R] = nums[L - 1];
        }
        return dp[L][R] = sum(nums, L, R) - Math.min(dfs(L + 1, R, nums), dfs(L, R - 1, nums));
    }

    public boolean predictTheWinner(int[] nums) {
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        // 只要能拿到多于一半的分数就能赢
        // 如果按照最优策略仍然拿不到超过一半分数，那无法保证获胜
        return dfs(1, nums.length, nums) * 2 >= sum(nums, 1, nums.length);
    }


    /**
     * 另外一种解法
     */
    public boolean predictTheWinner1(int[] nums) {
        int len = nums.length;
        int[][] memo = new int[len][len];
        for(int i=0; i<len; i++){
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        
        return dfs(nums, 0, len-1, memo) >= 0;
    }
    
    public int dfs(int[] nums, int start, int end, int[][] memo){
        if(start > end){
            return 0;
        }
        
        if(memo[start][end] != Integer.MIN_VALUE){
            return memo[start][end];
        }
        
        int ll = nums[start] - dfs(nums, start+1, end, memo);
        int rr = nums[end] - dfs(nums, start, end-1, memo);
        memo[start][end] = Math.max(ll, rr);
        return memo[start][end];
    }

}
