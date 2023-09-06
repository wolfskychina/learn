package leetcode.a200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用两个队列实现栈的功能
 */
public class _225Solution {
  
    class MyStack {

        private Queue<Integer> q;
        private Queue<Integer> q1;
    
        public MyStack() {
    
            q = new  LinkedList<>();
            q1 = new LinkedList<>();
        }
        
        public void push(int x) {
    
            int tmp;
            while(!q.isEmpty()){
    
                tmp = q.poll();
                q1.offer(tmp);
            }
            q.offer(x);
            while(!q1.isEmpty()){
    
                tmp = q1.poll();
                q.offer(tmp);
            }
            
        }
        
        public int pop() {

            return q.poll();
            
        }
        
        public int top() {
    
            return q.peek();
            
        }
        
        public boolean empty() {
    
                return q.isEmpty();
            
        }
    }
}
