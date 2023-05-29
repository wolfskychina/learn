package leetcode.array;
/**
 * 实现一个最小栈
 * 一个正常的栈外加实时返回栈内最小值的功能
 */
public class _155Solution {
   
    class MinStack {
        int [] num ;
        int [] min ;
        int top;
    
    /** initialize your data structure here. */
    public MinStack() {
  
       
            num  = new int[10000];
            min  = new int[10000];
            top = -1;
    
        
    }
    
    public void push(int x) {
        
        num[top+1] = x;
        if(top !=-1){
        min[top+1] = Math.min(x,min[top]);}
        else{
            min[top+1] = x;
        }
        top++;
    }
    
    public void pop() {
        if(top !=-1)
        top--;
    }
    
    public int top() {
        if(top !=-1)
        return num[top];
        else
            return -1;
    }
    
    public int getMin() {
        if(top != -1)
        return min[top];
        else
            return -1;
    }
}
}
