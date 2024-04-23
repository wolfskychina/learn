package leetcode.a2000;

/**
 * 大小写同时出现过的字符的数量
 * {easy}
 */
public class _3120Solution {

    public int numberOfSpecialChars(String word) {

        int counts[] = new int[26];
        int countb[] = new int[26];

        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                counts[c - 'a']++;
            } else {
                countb[c - 'A']++;
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0 && countb[i] != 0)
                res++;
        }

        return res;
    }
}
