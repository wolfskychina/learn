package leetcode.a2000;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 故障键盘,当输入字符i的时候，会将之前的输入全部反转，其他键正常
 * {queue}{deque}{classic}双端队列典型应用 
 * 
 */
public class _2810Solution {

    /**
     * 简单on2复杂度的模拟方法
     * @param s
     * @return
     */
    public String finalString(String s) {

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 'i')
                swap(arr, i);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != 'i')
                sb.append((char) c);
        }
        return sb.toString();
    }

    private void swap(char[] str, int end) {

        for (int i = 0; i < end - 1 - i; i++) {
            char tmp = str[i];
            str[i] = str[end - 1 - i];
            str[end - 1 - i] = tmp;
        }
    }

    /**
     * 使用双端队列的聪明办法，直接换方向插入
     * 实际顺序变了但是不需要搬动元素
     * @param s
     * @return
     */
    public String finalString1(String s) {
        Deque<Character> q = new ArrayDeque<>();
        boolean tail = true;
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                tail = !tail; // 修改添加方向
            } else if (tail) {
                q.addLast(c); // 加尾部
            } else {
                q.addFirst(c); // 加头部
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : q) {
            ans.append(c);
        }
        if (!tail) {
            ans.reverse();
        }
        return ans.toString();
    }

}
