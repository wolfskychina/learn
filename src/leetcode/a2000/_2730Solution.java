package leetcode.a2000;
/**
 * 最长的半重复字符子串
 * 半重复子串是指最多只有一对相邻字符相同
 * {two pointers}
 */
public class _2730Solution {

    public int longestSemiRepetitiveSubstring(String s) {

        if (s.length() == 1)
            return 1;
        int l = 0;
        int r = 0;
        int res = 1;
        boolean has = false;
        int last = 0;

        char[] ss = s.toCharArray();
        while (r < ss.length) {

            if (r > 0 && ss[r] == ss[r - 1]) {
                if (has) {
                    l = last + 1;
                } else {
                    has = true;
                }
                last = r - 1;

            }

            res = Math.max(res, r - l + 1);

            r++;

        }

        return res;

    }
}
