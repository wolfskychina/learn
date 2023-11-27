package leetcode.a500;

/**
 * 两个字符串，总共最少删除多少个字符，才能使剩下的字符串一致
 */
public class _583Solution {

    /**
     * {LCS},{longest common subsequence}
     * 开始时定义的dp[i][j]为word1中[0,i]的子串和word2中[0,j]的子串的lcs
     * 递推关系dp[i][j] = dp[i-1][j-1] + 1 || max(dp[i-1][j],dp[i][j-1])
     * 需要特殊考虑其中有值为0的情况，例如dp[0][j],如果用简单递推关系会越界
     * 所以不如让i和j整体变大1，但是需要证明变大后dp[1][i]和dp[0][i]的递推关系仍然正确
     * 重新定义dp[i][j]为w1中第i个字符结尾的子串和w2中第j个字符结尾的子串, 标号从1开始
     * 
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 1 : 0;
        for (int i = 1; i < m; i++)
            dp[i][0] = word1.charAt(i) == word2.charAt(0)?1:dp[i-1][0];
        for (int i = 1; i < n; i++)
            dp[0][i] = word1.charAt(0) == word2.charAt(i)?1:dp[0][i-1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                dp[i][j] = word1.charAt(i) == word2.charAt(j) ? dp[i - 1][j - 1] + 1
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);

            }
        }

        return m + n - 2 * dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

        _583Solution so = new _583Solution();
        so.minDistance("sea", "eat");
    }

}
