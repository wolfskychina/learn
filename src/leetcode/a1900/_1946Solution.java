package leetcode.a1900;

/**
 * 字符串中的字符按照映射表对某个子串进行映射之后
 * 所能得到的最大字符串
 * {greedy}
 */
public class _1946Solution {

    /**
     * 只有变大的映射才有意义，从左往右遍历
     * 涉及到贪心问题
     * 字符排序比大小的时候，相等的情况需要特别注意
     * @param num
     * @param change
     * @return
     */
    public String maximumNumber(String num, int[] change) {

        char[] str = num.toCharArray();
        int i = 0;
        while (i < str.length && str[i] -'0' >= change[str[i] - '0'])
            i++;
        // 因为要尽可能的变大，所以一旦开始变大之后，遇到变化后相等的也不能停
        while (i < str.length && str[i] - '0' <= change[str[i] - '0']) {
            str[i] = (char) ('0' + change[str[i] - '0']);
            i++;
        }
        return new String(str);

    }

    public static void main(String[] args) {

        _1946Solution so = new _1946Solution();
        String num = "132";
        int[] change = {9,8,5,0,3,6,4,2,6,8};
        so.maximumNumber(num, change);
    }
}
