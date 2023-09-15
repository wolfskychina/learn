package leetcode.a300;

import java.util.Stack;

/**
 * 给出一颗二叉树的前序遍历序列，空节点用#号代替
 * 判断给出的前序遍历序列是否合法
 */
public class _331Solution {

    public static boolean isValidSerialization(String s) {
        if (s == null || s.length() == 0)
            return true;
        String[] str = s.split(",");
        int n = str.length;
        if ("#".equals(str[0]) && n > 1)
            return false;
        if ("#".equals(str[0]))
            return true;

        // 如果用arrayDeque比Stack要快
        // Stack是线程安全的
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            String c = str[i];
            if (!"#".equals(c)) { // 遇到的不是'#'，直接入栈
                stack.push(c);
                i++;
            } else {

                while (stack.size() > 0 && "#".equals(stack.peek())) { // 遇到'#'，当前栈顶也是'#'，弹出2个字符，压入1个'#'
                    stack.pop();
                    if (stack.isEmpty())
                        return false;
                    stack.pop();
                    // i 位置不动，继续处理当前字符'#'，循环判断是否依旧满足2）
                }
                // 栈顶不是'#'，直接入栈
                stack.push(c);
                i++;

            }
        }
        return stack.size() == 1 && "#".equals(stack.peek());
    }
}
