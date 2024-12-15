package leetcode.a1300;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 每次将数组里面所有x大小的数组全部删除
 * 最少删除多少次才能让剩下的元素数量小于开始的一半
 * {counting},{priority queue},{easy}
 */
public class _1338Solution {

    public int minSetSize(int[] arr) {

        int count[] = new int[100001];
        for (int i : arr) {
            count[i]++;
        }
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int i : count) {
            if (i != 0)
                q.offer(i);
        }

        int sum = 0;
        int res = 0;
        while (sum < arr.length / 2) {
            sum += q.poll();
            res++;
        }
        return res;
    }
}
