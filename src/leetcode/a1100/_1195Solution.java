package leetcode.a1100;

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
     * {multi thread}
     * CyclicBarrier的使用，同一组的所有线程满足条件后开始下一轮
     * 因为四种输出的条件是互斥的，不存在同时触发某两个条件的情况
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


    /**
     * 另外一种使用synchronized关键字和notifyAll()的方法
     * {synchronized}
     */
    class FizzBuzz1 {
        private int n;
        private int counter = 1;
        public FizzBuzz1(int n) {
            this.n = n;
        }
    
        // printFizz.run() outputs "fizz".
        public synchronized void fizz(Runnable printFizz) throws InterruptedException {
            while (true) {
                while (counter <= n && (counter % 3 != 0 || counter % 5 == 0)) {
                    wait();
                }
                if (counter > n) break;
                printFizz.run();
                counter++;
                notifyAll();
            }
        }
    
        // printBuzz.run() outputs "buzz".
        public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
            while (true) {
                while (counter <= n && (counter % 5 != 0 || counter % 3 == 0)) {
                    wait();
                }
                if (counter > n) break;
                printBuzz.run();
                counter++;
                notifyAll();
            }
        }
    
        // printFizzBuzz.run() outputs "fizzbuzz".
        public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (true) {
                while (counter <= n && (counter % 3 != 0 || counter % 5 != 0)) {
                    wait();
                }
                if (counter > n) break;
                printFizzBuzz.run();
                counter++;
                notifyAll();
            }
        }
    
        // printNumber.accept(x) outputs "x", where x is an integer.
        public synchronized void number(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                while (counter <= n && (counter % 3 == 0 || counter % 5 == 0)) {
                    wait();
                }
                if (counter > n) break;
                printNumber.accept(counter);
                counter++;
                notifyAll();
            }
        }
    }

}