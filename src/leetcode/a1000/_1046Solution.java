package leetcode.a1000;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 石头互相碰撞问题
 * {easy},{Priority Queue}
 */
public class _1046Solution {

    public int lastStoneWeight(int[] stones) {

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : stones) {
            q.offer(i);
        }

        while (q.size() >= 2) {
            int larger = q.poll();
            int smaller = q.poll();
            if (larger > smaller)
                q.offer(larger - smaller);

        }
        return q.size() == 1 ? q.poll() : 0;
    }
}