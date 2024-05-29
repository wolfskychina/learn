package leetcode.a300;
/**
 * 判断一个字符串是不是另一个字符串的子序列
 * {subsequence},{easy}
 */
public class _392Solution {

    public boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;
        int lens = s.length();
        int lent = t.length();
        if (lens > lent)
            return false;
        while (i != lens && j != lent) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                continue;
            } else {
                j++;
            }

        }

        return i == lens ? true : false;

    }
}
