package leetcode.a1500;

import java.util.Stack;

import leetcode.util.charnode.Node;

/**
 * 利用中缀表达式构造二叉表达式树
 * 只有各位数字和四则运算符和括号
 */
public class _1597Solution {

    /**
     * 先将中缀表达式转换为后缀表达式
     */
    public Node expTree(String s) {
        s = infixToPostfix(s);
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 先利用当前值构造Node节点
            Node tmp = new Node(s.charAt(i));
            switch (tmp.val) {
                case '+':
                case '-':
                case '*':
                case '/':
                    // 运算符节点有左右两个儿子，两个儿子通过弹栈获取
                    tmp.right = stack.pop();
                    tmp.left = stack.pop();
                    break;
                default:
                    // 运算数节点没有儿子
            }
            stack.push(tmp);
        }
        return stack.pop();
    }

    /**
     * TODO 单字符逆波兰表达式的生成：
     * 中缀表达式转换为后缀表达式 "3*4-2*5" -> "34*25*-"
     * 后缀表达式也就是逆波兰表达式。
     * 仅适用于单个字符数字的转换
     * 如果有多位数字的情况，需要识别整个数字，然后作为一个整体入栈
     */
    private String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '+':
                case '-':
                    // 括号表示影响范围的终结
                    while (!stack.isEmpty() && stack.peek() != '(')
                        sb.append(stack.pop());
                    stack.push(s.charAt(i));
                    break;
                case '*':
                case '/':
                    // 只要不是+-操作的都会受到*/运算的影响，所以需要出栈再入栈
                    while (!stack.isEmpty() && stack.peek() != '(' && stack.peek() != '+' && stack.peek() != '-')
                        sb.append(stack.pop());
                    stack.push(s.charAt(i));
                    break;
                case '(':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    while (stack.peek() != '(')
                        sb.append(stack.pop());
                    // 左括号弹出
                    stack.pop();
                    break;
                default:
                    stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }
}
