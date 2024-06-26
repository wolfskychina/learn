package leetcode.a200;

/**
 * 判断两个字符串是不是由完全相同的字符组合合成
 * {easy}
 */
public class _242Solution {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int a[] = new int[26];
        for (char c : s.toCharArray()) {

            a[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            a[c - 'a']--;
            if (a[c - 'a'] < 0)
                return false;
        }

        return true;

    }
}
