package leetcode.a1900;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 移除石子使总数最小
 * {Priority queue},{easy}
 */
public class _1962Solution {

    public int minStoneSum(int[] piles, int k) {

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : piles) {
            q.offer(i);
        }

        while (k > 0) {

            int tmp = q.poll();
            q.offer(tmp - tmp / 2);
            k--;
        }

        int res = 0;
        for (int i : q) {
            res += i;
        }
        return res;
    }
}
