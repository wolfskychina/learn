package leetcode.a3000;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 第k近的障碍物查询
 * {Priority Queue}
 */
public class _3275Solution {

    public int[] resultsArray(int[][] queries, int k) {
        int res[] = new int[queries.length];
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < res.length; i++) {

            int cur = Math.abs(queries[i][0]) +
                    Math.abs(queries[i][1]);
            if (q.size() < k) {
                q.offer(cur);
            } else if (q.peek() > cur) {
                q.poll();
                q.offer(cur);
            }

            if (q.size() == k) {
                res[i] = q.peek();
            } else {
                res[i] = -1;
            }
        }

        return res;
    }
}
