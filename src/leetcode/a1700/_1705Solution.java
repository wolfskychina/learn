package leetcode.a1700;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 能吃到的苹果的最大数目
 * 苹果树连续n天产生苹果
 * 苹果树每天产生的苹果数量和当日产生苹果的新鲜日期都不同
 * 每天最多只能吃一个苹果
 * 求最多能吃到多少个苹果
 * n天过后仍然可以吃苹果，但是不产生苹果
 * {priority queue},{greedy}
 */
public class _1705Solution {

    /**
     * 最先要烂的苹果先吃
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
        int num = 0;
        int day = 0;
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int idx = 0;
        while (day < apples.length || !q.isEmpty()) {

            while (!q.isEmpty() && q.peek()[1] <= day)
                q.poll();
            if (idx < apples.length) {
                if (apples[idx] != 0) {
                    int[] pair = new int[2];
                    pair[0] = apples[idx];
                    pair[1] = day + days[idx];
                    q.offer(pair);
                }
                idx++;
            }
            if (!q.isEmpty()) {
                int[] pair = q.poll();
                pair[0]--;
                if (pair[0] != 0) {
                    q.offer(pair);
                }
                num++;
            }

            day++;
        }

        return num;
    }
}
