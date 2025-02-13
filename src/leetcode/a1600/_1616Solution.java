package leetcode.a1600;

/**
 * 两个相同长度的字符串，从相同的坐标切开后，一个字符串的前半部分和另一个
 * 的后半部分拼接
 * 能否形成回文串
 * {palindrome},{greedy}
 */
public class _1616Solution {

    /**
     * 符合贪心原则
     * 只需要一趟扫描
     * @param a
     * @param b
     * @return
     */
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    // 如果 a_prefix + b_suffix 可以构成回文串则返回 true，否则返回 false
    private boolean check(String a, String b) {
        int i = 0, j = a.length() - 1; // 相向双指针
        while (i < j && a.charAt(i) == b.charAt(j)) { // 前后缀尽量匹配
            ++i;
            --j;
        }
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }

    // 如果从 s[i] 到 s[j] 是回文串则返回 true，否则返回 false
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j && s.charAt(i) == s.charAt(j)) {
            ++i;
            --j;
        }
        return i >= j;
    }
}
