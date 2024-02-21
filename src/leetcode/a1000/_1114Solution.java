package leetcode.a1000;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * 多线程按顺序打印
 * {multi thread},{concurrency}
 */
public class _1114Solution {

    class Foo {
        private AtomicInteger firstJobDone = new AtomicInteger(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstJobDone.incrementAndGet();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (firstJobDone.get() != 1) {
                // waiting for the first job to be done.
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            firstJobDone.incrementAndGet();

        }

        public void third(Runnable printThird) throws InterruptedException {
            while (firstJobDone.get() != 2) {
                // waiting for the second job to be done.
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
