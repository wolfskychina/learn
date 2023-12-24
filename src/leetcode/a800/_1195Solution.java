package leetcode.a800;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;
/**
 * 四个线程并行输出四种消息
 * 将if中的四个分支拆到四个线程中
 * 
 */
public class _1195Solution {
   
    /**
     * {multitread}
     * CyclicBarrier的使用，同一组的所有线程满足条件后开始下一轮
     */
    public class FizzBuzz {

        int n;
        private static CyclicBarrier barrier = new CyclicBarrier(4);
        
        public FizzBuzz(int n) {
            this.n = n;
        }
    
        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                }
                try {
                    barrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    
        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 == 0) {
                    printBuzz.run();
                }
                try {
                    barrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    
        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    printFizzBuzz.run();
                }
                try {
                    barrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    
        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                }
                try {
                    barrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
   
}

}
