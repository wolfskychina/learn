package leetcode.a600;

import java.util.Stack;

/**
 * 判断一个括号序列是否是合法序列
 * 除了()还有*号，*号可以表示(,),和空
 */
public class _678Solution {

    /**
     * {stack},{greedy} 两轮处理
     * 第一轮遍历的时候对于右括号，对栈里面的(和*进行匹配出栈，其中(的优先级更高，匹配栈最上部的(
     * 如果没有(，才匹配*
     * 对于遍历完一遍的栈，再依次出栈，判断剩下的(能否由*来匹配
     * 
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {

        Stack<Character> stack = new Stack<>();
        int leftNum = 0;
        int starNum = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push('(');
                leftNum++;
            } else if (s.charAt(i) == '*') {
                stack.push('*');
                starNum++;
            } else {
                if (leftNum > 0) {
                    leftNum--;
                    int count = 0;
                    while (stack.peek() != '(') {
                        count++;
                        stack.pop();
                    }
                    stack.pop();
                    while (count != 0) {
                        count--;
                        stack.push('*');
                    }
                } else if (starNum > 0) {
                    starNum--;
                    stack.pop();
                } else {
                    return false;
                }
            }

        }

        if (leftNum == 0)
            return true;
        starNum = 0;
        while (!stack.isEmpty()) {
            if (leftNum == 0)
                return true;
            char c = stack.pop();
            if (c == '*')
                starNum++;
            else {
                if (starNum == 0)
                    return false;
                starNum--;
                leftNum--;
            }
        }
        if (leftNum == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        _678Solution so = new _678Solution();
        so.checkValidString(
                "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()");
    }
}
