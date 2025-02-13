package leetcode.a2000;

/**
 * 连接双字符长度单词所能得到的最长回文串
 * {palindrome},{greedy}
 */
public class _2131Solution {

    public int longestPalindrome(String[] words) {

        int count[][] = new int[26][26];
        for (String str : words) {

            count[str.charAt(0) - 'a'][str.charAt(1) - 'a']++;
        }
        int sum = 0;
        boolean ext = false;
        for (int i = 0; i < 26; i++) {

            if (count[i][i] % 2 == 1) {
                ext = true;
            }
            sum += count[i][i] / 2 * 2;

            for (int j = i + 1; j < 26; j++) {
                sum += Math.min(count[i][j], count[j][i]) * 2;
            }
        }

        return ext ? (sum + 1) * 2 : sum * 2;
    }
}
