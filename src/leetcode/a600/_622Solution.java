package leetcode.a600;
/**
 * 长度为k的循环队列
 * {data structure},{design}
 */
public class _622Solution {
   
    class MyCircularQueue {

        int[] queue;
        int len = 0;
        int head =0;
        int tail =0;

        public MyCircularQueue(int k) {
                queue = new int[k];
        }
        
        public boolean enQueue(int value) {

            if(len == queue.length)
                return false;
            
            queue[tail] =value;
            tail = (tail+1)%queue.length;
            len++;
            return true;
    
        }
        
        public boolean deQueue() {
            if(len==0)
                return false;
            head = (head+1)%queue.length;
            len--;
            return true;
    
        }
        
        public int Front() {

            if(len==0) return -1;
            return queue[head];
    
        }
        
        public int Rear() {
            if(len==0) return -1;
            return queue[(tail+queue.length-1)%queue.length];
    
        }
        
        public boolean isEmpty() {

            return len==0;
    
        }
        
        public boolean isFull() {

            return len==queue.length;
    
        }
    }
    
    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     */
}
