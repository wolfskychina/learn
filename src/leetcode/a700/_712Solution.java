package leetcode.a700;
/**
 * 两个字符串，分别删除其中的一些字符，使得剩下的字符串相等
 * 求这些删掉的字符的ascii码和的最小值可以是多少？
 */
public class _712Solution {

    /**
     * {LCS}的变种问题，设dp[i][j]是s1,s2长度为i,j的前缀子串[0,i-1],[0,j-1]
     * 递推的时候直接加上删掉字符的ascii码
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {

        // lcs
        int m = s1.length();
        int n = s2.length();
        // String lis;
        // dp[i][j] is the minimum sum of s1.sub(0,i+1) s2.sub(0,j+1)
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char char1 = s1.charAt(i - 1);
                char char2 = s2.charAt(j - 1);
                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + char1, dp[i][j - 1] + char2);
                }
            }
        }

        return dp[m][n];
    }

    /*
     * int dellen = 0;
     * for(int i=0;i<s1.length();i++){
     * dellen += s1.charAt(i);
     * }
     * for(int i=0;i<s1.length();i++){
     * dellen += s2.charAt(i);
     * }
     * for(int i=0;i<lis.length();i++){
     * dellen -= 2*lis.charAt(i);
     * 
     * }
     * return dellen;
     */

}
