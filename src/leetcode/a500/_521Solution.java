package leetcode.a500;
/**
 * 两个字符串的最长非共享子序列的长度
 */
public class _521Solution {

    /**
     * 如果a，b相等，那么不存在非共享子序列
     * 如果不相等，那么最长非共享子序列就是更长的那个字符串
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        else
            return a.length() > b.length() ? a.length() : b.length();

    }
}
