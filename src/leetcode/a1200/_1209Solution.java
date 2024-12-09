package leetcode.a1200;

import java.util.Stack;

/**
 * 删除字符串中的所有k长度的单一字符子串
 * {stack}
 */
public class _1209Solution {

    /**
     * 利用栈实现on时间复杂度
     * 栈内保存当前字符重复出现的次数
     * 只有不同字符的时候才入栈，相同的元素只更新出现次数
     * 只有出现次数达到k的时候才出栈
     * @param s
     * @param k
     * @return
     */
    public String removeDuplicates1(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.push(1);
            } else {
                int incremented = counts.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 用数组模拟栈,速度更快
     * @param s
     * @param k
     * @return
     */
    public String removeDuplicates(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] count = new int[len];
        int i = 0;
        for (int j = 0; j < len; j++, i++) {
            arr[i] = arr[j];
            if (i > 0 && arr[i - 1] == arr[j]) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = 1;
            }
            if (count[i] == k) {
                i -= k;
            }
        }
        return new String(arr, 0, i);

    }
}
