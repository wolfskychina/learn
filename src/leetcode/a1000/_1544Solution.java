package leetcode.a1000;

import java.util.Stack;

/**
 * 消除字符串中相邻的大小写字符对
 */
public class _1544Solution {

    public String makeGood(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() - c == 'A' - 'a' ||
                        stack.peek() - c == 'a' - 'A')
                    stack.pop();
                else
                    stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) stack.pop());
        }
        return sb.reverse().toString();
    }

    /**
     * 用一个数组模拟栈
     * {simulate stack}
     * @param s
     * @return
     */
    public String makeGood1(String s) {
        char[] res = new char[s.length()];
        int index = -1;
        for (char c : s.toCharArray()) {
            if (index >= 0) {
                char pre = res[index];
                if (c == pre + 32 || c == pre - 32) {
                    index--;
                    continue;
                }
            }
            res[++index] = c;
        }
        return new String(res, 0, index + 1);
    }
}
