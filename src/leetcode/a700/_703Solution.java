package leetcode.a700;

import java.util.PriorityQueue;
/**
 * 数据流中的第k大的数字
 */
public class _703Solution {

    /**
     * {min heap},{priority queue}
     */
    class KthLargest {
        PriorityQueue<Integer> queue;
        int topK;

        public KthLargest(int k, int[] nums) {
            topK = k;
            queue = new PriorityQueue<Integer>();
            for (int i = 0; i < nums.length; i++) {
                this.add(nums[i]);
            }
        }

        public int add(int val) {
            queue.offer(val);
            if (queue.size() > topK) {
                queue.poll();
            }
            return queue.peek();
        }
    }
}
