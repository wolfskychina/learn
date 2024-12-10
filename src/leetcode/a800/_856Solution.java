package leetcode.a800;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * TODO 括号的得分
 * 计算方式()一分，()()相邻括号分数相加，嵌套括号分数*2
 */
public class _856Solution {
   
    /**
     * {stack}
     * 
     * @param s
     * @return
     */
    public int scoreOfParentheses(String s) {
        Deque<Integer> d = new ArrayDeque<>();
        // A+B算分的情况，防止A为空只有一个加数的情况
        d.addLast(0);
        for (char c : s.toCharArray()) {
            if (c == '(') d.addLast(0);
            else {
                int cur = d.pollLast();
                d.addLast(d.pollLast() + Math.max(cur * 2 , 1));
            }
        }
        return d.peekLast();
    }
}
