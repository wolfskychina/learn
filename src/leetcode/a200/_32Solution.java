package leetcode.a200;

import java.util.Stack;

public class _32Solution {

    public int longestValidParentheses(String s){
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
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
