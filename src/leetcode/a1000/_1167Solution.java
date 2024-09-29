package leetcode.a1000;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 将所有木棍粘到一起的最小花费
 * 每次粘结的花费是两个木棍的长度之和
 */
public class _1167Solution {

    /**
     * 很容易排序后简单相加，实际上前面粘贴过后，所有木棍的长度可能动态发生了
     * 变化。需要实时排序的优先队列。
     * {PriorityQueue},{greedy}
     * 
     * @param sticks
     * @return
     */
    public int connectSticks(int[] sticks) {
        int totalCost = 0;

        Queue<Integer> pq = new PriorityQueue<>();

        // 所有棍子都添加到最小堆中
        for (int stick : sticks) {
            pq.add(stick);
        }

        // 把两根最小的棍子合起来，直到只剩下一根。
        while (pq.size() > 1) {
            int stick1 = pq.remove();
            int stick2 = pq.remove();

            int cost = stick1 + stick2;
            totalCost += cost;

            pq.add(stick1 + stick2);
        }

        return totalCost;
    }
}
