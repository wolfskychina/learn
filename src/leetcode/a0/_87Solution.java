package leetcode.a0;

/**
 * {dp}
 */
public class _87Solution {

    public boolean isScramble(String s1, String s2) {
        int m = s1.length();
        int[] cnts = new int[26];
        for (int i = 0; i < m; i++) {
            cnts[s1.charAt(i) - 'a']++;
            cnts[s2.charAt(i) - 'a']--;

        }
        for (int i : cnts) {
            if (cnts[i] != 0)
                return false;
        }
        if (m <= 3)
            return true;

        for (int i = 1; i < m; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(m - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, m - i)))
                return true;
        }

        return false;
    }

}
