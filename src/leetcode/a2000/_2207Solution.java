package leetcode.a2000;

/**
 * 字符串中最多数目的子序列
 * 长度为2的pattern，允许往文本里面的任何位置插入pattern的任意一个字符
 * 形成的新文本中，最多包含多少个pattern
 * {subsequence},{prefix sum}
 */
public class _2207Solution {

    public long maximumSubsequenceCount(String text, String pattern) {

        String pre = pattern.charAt(0) + text;
        String post = text + pattern.charAt(1);

        return Math.max(countMaxSub(pre, pattern),
                countMaxSub(post, pattern));
    }

    private long countMaxSub(String str, String pattern) {

        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        long res = 0;
        long prefix = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == p[0]) {
                prefix++;
            } else if (s[i] == p[1]) {
                res += prefix;
            }
        }
        if (p[0] == p[1])
            return prefix * (prefix - 1) / 2;
        return res;

    }

    /**
     * 更简洁的一种方法
     * @param text
     * @param pattern
     * @return
     */
    public long maximumSubsequenceCount1(String text, String pattern) {
        char x = pattern.charAt(0);
        char y = pattern.charAt(1);
        long ans = 0;
        int cntX = 0;
        int cnyY = 0;
        for (char c : text.toCharArray()) {
            if (c == y) {
                ans += cntX;
                cnyY++;
            }
            if (c == x) {
                cntX++;
            }
        }
        return ans + Math.max(cntX, cnyY);
    }
}
