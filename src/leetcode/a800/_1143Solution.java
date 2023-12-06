package leetcode.a800;

public class _1143Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        char[] txt1 = text1.toCharArray();
        char[] txt2 = text2.toCharArray();

        int dp[][] = new int[txt1.length + 1][txt2.length + 1];

        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {

                if (txt1[i-1] == txt2[j-1]) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[dp.length - 1][dp[0].length - 1];

    }
}
