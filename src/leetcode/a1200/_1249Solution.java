package leetcode.a1200;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 去除不合法的括号
 * {stack}
 */
public class _1249Solution {

    /**
     * 关键点：用栈遍历括号序列，会出现两种不合法的情况
     * 1.空栈的时候遇到）括号
     * 2.最后完全扫描完的情况下，栈里面残留的（号都是无法匹配的
     * 栈只保存（括号的索引
     * @param s
     * @return
     */
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    // )号不合法的情况
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        // Put any indexes remaining on stack into the set.
        // 栈里面残留的是（号不合法的情况
        while (!stack.isEmpty())
            indexesToRemove.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
