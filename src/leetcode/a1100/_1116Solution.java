package leetcode.a1100;

import java.util.function.IntConsumer;

/**
 * 使用三个线程，按照010203...的顺序输出小于等于n的数
 * 三个线程分别输出0,1,2
 */
public class _1116Solution {
   
    /**
     * {multi thread}
     */
    class ZeroEvenOdd {
        private int n;
        private volatile int flag = 1;
        
        public ZeroEvenOdd(int n) {
            this.n = n;
        }
    
        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i=1; i<=n; i++) {
                synchronized (this) {
                    while (flag % 2 == 0) wait();
                    printNumber.accept(0);
                    flag ++;
                    notifyAll();
                }
            }
        }
    
        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i=2; i<=n; i+=2) {
                synchronized (this) {
                    while (flag % 4 != 0) wait();
                    printNumber.accept(i);
                    flag ++;
                    notifyAll();
                }
            }
        }
    
        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i=1; i<=n; i+=2) {
                synchronized(this) {
                    while (flag % 4 != 2) wait();
                    printNumber.accept(i);
                    flag ++;
                    notifyAll();
                }
            }
        }
    }
    
}
