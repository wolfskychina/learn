package leetcode.a1000;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * 所有人排名前五的平均分
 * {easy}
 */
public class _1086Solution {

    public int[][] highFive(int[][] items) {

        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int[] item : items) {

            Queue<Integer> q = map.getOrDefault(item[0], new PriorityQueue<Integer>((o1, o2) -> o2 - o1));
            q.offer(item[1]);
            map.put(item[0], q);
        }

        int[][] res = new int[map.keySet().size()][2];
        int idx = 0;
        for (int id : map.keySet()) {
            Queue<Integer> queue = map.get(id);
            int avg = 0;
            for (int i = 0; i < 5; i++) {
                avg += queue.poll();
            }
            avg /= 5;
            res[idx][0] = id;
            res[idx][1] = avg;
            idx++;
        }

        return res;
    }
}
