package leetcode.a1000;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 座位预约管理
 * {design},{Priority Queue},{easy}
 */
public class _1845Solution {

    class SeatManager {

        Queue<Integer> pool;

        public SeatManager(int n) {
            pool = new PriorityQueue<>();
            for (int i = 1; i <= n; i++) {
                pool.offer(i);
            }
        }

        public int reserve() {
            return pool.poll();
        }

        public void unreserve(int seatNumber) {

            pool.offer(seatNumber);

        }
    }
}
