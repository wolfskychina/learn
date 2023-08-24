package leetcode.a200;

public class _115Solution {
   
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 1;
        }
        
        for (int j = 1; j < m+1; j++) {
            dp[0][j] = 0;
        }
        
        // ij两行遍历互换位置也可以
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
            
                // s.charAt(i-1) != t.charAt(j-1),表示s的第i个元素不等于t的第j个元素
                // 不管 s.charAt(i-1) 和 t.charAt(j-1)是否相等，dp[i-1][j]所代表的的子序列集合仍然有效，i增大了，j的数量没变。
                dp[i][j] = dp[i-1][j];
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    // 首先原来dp[i-1][j]里面的所有解都有效！
                    // 说明dp[i-1][j-1]里面的元素，加上s的第i个元素，也成了符合条件的子序列。这种情况下的子序列的最后一位必须是i
                    // 这一部分是由dp[i-1][j-1]的所有解，拼接上s[i].t[j]构成的
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        
        return dp[n][m];
    }
}
