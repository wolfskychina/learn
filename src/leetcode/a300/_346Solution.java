package leetcode.a300;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 346. Moving Average from Data Stream
 * {easy}
 */
public class _346Solution {

    /**
     * 速度比较慢
     */
    class MovingAverage {
        int wsize;
        Queue<Integer> q;
        double sum = 0;

        public MovingAverage(int size) {
            this.wsize = size;
            q = new LinkedList<>();
        }

        public double next(int val) {

            if (q.size() < wsize) {
                q.offer(val);

                sum += val;

            } else {
                q.offer(val);

                sum += (val - q.poll());
            }

            return sum / q.size();
        }
    }

    /**
     * 使用一个环形数组来模拟队列
     */
    class MovingAverage2 {
        int size, head = 0, windowSum = 0, count = 0;
        int[] queue;

        public MovingAverage2(int size) {
            this.size = size;
            queue = new int[size];
        }

        public double next(int val) {
            ++count;
            // calculate the new sum by shifting the window
            int tail = (head + 1) % size;
            windowSum += val - queue[tail];
            // move on to the next head
            head = (head + 1) % size;
            queue[head] = val;
            return windowSum * 1.0 / Math.min(size, count);
        }
    }

}
