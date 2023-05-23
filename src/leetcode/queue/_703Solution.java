package leetcode.queue;

import java.util.PriorityQueue;

/**
 * 找出一个流中的第k大的元素
 */
public class _703Solution {
   
    // 最简单的思路就是用共有k个元素的最大堆，
    // 那么最大堆顶端的元素就是第k大的元素
    class KthLargest {
        final PriorityQueue<Integer> q;
        final int k;

        public KthLargest(int k, int[] a) {
            this.k = k;
            q = new PriorityQueue<>(k);
            for (int n : a)
                add(n);
        }

        public int add(int n) {
            if (q.size() < k)
                q.offer(n);
            else if (q.peek() < n) {
                q.poll();
                q.offer(n);
            }
            return q.peek();
        }
    }
}
