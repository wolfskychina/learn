package leetcode.a1100;
/**
 * 单词能否由char数组中的字符拼成
 * {easy}
 */
public class _1160Solution {

    public int countCharacters(String[] words, String chars) {

        int count = 0;
        int[] pattern = new int[26];
        for (char c : chars.toCharArray()) {

            pattern[c - 'a']++;
        }
        for (String str : words) {

            if (str.length() > chars.length())
                continue;
            int[] p = pattern.clone();
            boolean can = true;
            for (char c : str.toCharArray()) {

                if (p[c - 'a'] == 0) {
                    can = false;
                    break;
                } else {
                    p[c - 'a']--;
                }
            }
            if (can)
                count += str.length();

        }

        return count;
    }
}
