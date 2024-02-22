package leetcode.a0;

import java.util.Stack;
/**
 * 计算括号串中最长的合法字符串
 * {stack}
 */
public class _32Solution {

    public int longestValidParentheses(String s){
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        // 这里只能填-1，计算长度才正确
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            } else {
                stack.pop();
                if(stack.empty()){
                    stack.push(i);
                }else{
                    maxans = Math.max(maxans,i-stack.peek());
                }
            }
        }

        return maxans;
    }

    public static void main(String[] args){

        _32Solution so = new _32Solution();
        System.out.println(so.longestValidParentheses("())((())))"));
    }
}
