package leetcode.a300;

import java.util.Stack;

/**
 * 使用两个栈实现队列的功能
 */
public class _232Solution {
   
    class MyQueue {

        Stack<Integer> s1,s2;
    
        public MyQueue() {
            s1 = new Stack<Integer>();
            s2 = new Stack<Integer>();
            
        }
        
        public void push(int x) {
            int tmp = 0;
            while(!s1.isEmpty()){
                tmp = s1.pop();
                s2.push(tmp);
            }
            s1.push(x);
            while(!s2.isEmpty()){
                tmp = s2.pop();
                s1.push(tmp);
            }
            
        }
        
        public int pop() {
            return s1.pop();
        }
        
        public int peek() {
            return s1.peek();
        }
        
        public boolean empty() {
            return s1.isEmpty();
        }
    }

}
