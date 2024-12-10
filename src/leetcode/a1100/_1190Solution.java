package leetcode.a1100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * TODO 反转每对括号中的子串
 * {stack}借助栈作为辅助结构
 * 
 */
public class _1190Solution {

    /**
     * 
     * @param s
     * @return
     */
    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
