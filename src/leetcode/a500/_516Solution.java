package leetcode.a500;
/**
 * 字符串的最长回文子序列
 * {dp},{subsequence}
 */
public class _516Solution {

    /**
     * dp算法，向两端逐渐生长
     * 
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {

        int[][] a = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            a[i][i] = 1;
        }
        for (int j = 1; j < s.length(); j++) {

            for (int i = j - 1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    a[i][j] = a[i + 1][j - 1] + 2;
                } else {
                    if (a[i][j - 1] > a[i + 1][j]) {

                        a[i][j] = a[i][j - 1];
                    } else {
                        a[i][j] = a[i + 1][j];
                    }
                }
            }
        }

        return a[0][s.length() - 1];

    }
}
