package leetcode.a1300;

/**
 * 破坏回文串
 * 给一个回文串，允许改变一个字符使得字符串所形成的非回文串最小
 * {greedy}
 */
public class _1328Solution {

    public String breakPalindrome(String palindrome) {

        if (palindrome.length() == 1)
            return "";
        char[] s = palindrome.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < palindrome.length() / 2; i++) {
            count[s[i] - 'a']++;
            if (s[i] != 'a') {
                s[i] = 'a';
                return new String(s);
            }
        }
        s[s.length - 1] = 'b';
        return new String(s);
    }
}
