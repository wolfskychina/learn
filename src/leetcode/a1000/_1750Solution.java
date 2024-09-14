package leetcode.a1000;

/**
 * 不断重复删除字符串两端的相同重复字符之后剩下的子串长度
 * {two pointers},{TODO}
 */
public class _1750Solution {

    /**
     * 
     * @param s
     * @return
     */
    public int minimumLength(String s) {

        int n = s.length();
        int left = 0, right = n - 1;
        char[] ss = s.toCharArray();
        // 必须能比较才能走循环，避免两个指针指向单个字符也进行比较
        while (left < right && ss[left] == ss[right]) {
            char c = ss[left];
            while (left <= right && ss[left] == c) {
                left++;
            }
            while (left <= right && ss[right] == c) {
                right--;
            }
        }
        return right - left + 1;

    }

    public static void main(String[] args) {

        _1750Solution so = new _1750Solution();
        String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
        so.minimumLength(s);
    }
}
