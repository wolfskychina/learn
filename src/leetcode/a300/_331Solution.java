package leetcode.a300;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给出一颗二叉树的前序遍历序列，前序访问到null节点用#号代替
 * 判断给出的前序遍历序列是否合法
 * {binary tree},{classic}
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
        Deque<String> stack = new LinkedList<>();
        int i = 0;
        while (i < n) {
            String c = str[i];
            if (!"#".equals(c)) { // 遇到的不是'#'，直接入栈
                stack.push(c);
                i++;
            } else {

                // 模拟的是叶子节点访问完后递归的返回
                while (stack.size() > 0 && "#".equals(stack.peek())) { 
                    
                    // 遇到'#'，当前栈顶也是'#'，弹出2个字符，压入1个'#'
                    // 这个#是将遍历完左右null的叶子节点置为其父节点的#，表示该节点已经遍历完
                    // 返回
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

    /**
     * 另外一种解法，判断二叉树应该有的位置数量和数列中元素占据的位置是否相等
     * 
     * @param preorder
     * @return
     */
    public boolean isValidSerialization2(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                slots--;
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
            }
        }
        return slots == 0;
    }

    public static void main(String[] args) {
        _331Solution so = new _331Solution();
        so.isValidSerialization2("9,#,92,#,#");

    }
}
