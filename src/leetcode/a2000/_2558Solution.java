package leetcode.a2000;

import java.util.PriorityQueue;
import java.util.Queue;
/**
 * 从数量最多的堆取走礼物,第k步之后还剩多少
 * {easy}
 */
public class _2558Solution {

    public long pickGifts(int[] gifts, int k) {

        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        long total = 0;
        for (int i : gifts) {
            q.offer(i);
            total += i;
        }
        long take = 0;
        for (int i = 0; i < k; i++) {

            int pile = q.poll();
            int remain = (int) Math.sqrt(pile);
            take += pile - remain;
            if (remain != 0) {
                q.offer(remain);
            }
        }
        return total - take;
    }
}
