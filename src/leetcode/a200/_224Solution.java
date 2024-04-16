package leetcode.a200;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 基本计算器，只有加减法和括号的运算
 * {math},{stack}
 */
public class _224Solution {
   
    /**
     * 因为加减法优先级一样的，所以括号最多改变口号内每个数字的正负
     * 思路：模拟拆括号的操作，将所有括号拆掉，然后再运算
     * 栈里面只存正负号，表示左括号前面的正负号对该括号内数字的影响
     * （不变或者取反）TODO
     * @param s
     * @return
     */
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                // 当前正负号暂存，并且当前正负号不变
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                // 弹出）括号对应的左括号时暂存的正负号
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

}
