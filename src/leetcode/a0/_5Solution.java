package leetcode.a0;

/**
 * Longest Palindrome
 * 最长回文子串
 * 中心向两侧生成的方式，有两种生成的模式
 * 时间复杂度为n2
 */
public class _5Solution {

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                // 统一奇偶数的处理方法
                // 左侧这么处理，奇偶不受影响
                start = i - (len - 1) / 2;
                // 右侧这么处理，len偶数的时候比奇数长度多一
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;//r-l+1-2
    }
}
