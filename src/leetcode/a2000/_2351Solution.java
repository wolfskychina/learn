package leetcode.a2000;
/**
 * 第一个出现两次的字母
 * {easy}
 */
public class _2351Solution {

    public char repeatedCharacter(String s) {
        int count[] = new int[26];
        for (char c : s.toCharArray()) {

            if (count[c - 'a'] == 1)
                return c;
            count[c - 'a']++;
        }

        return ' ';
    }
}
