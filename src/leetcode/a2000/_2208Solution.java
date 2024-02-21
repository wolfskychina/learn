package leetcode.a2000;

import java.util.PriorityQueue;
/**
 * 将数组之和降低为原来一半的最少操作次数
 * 每次操作可以将数组中的一个元素减半
 */
public class _2208Solution {
   
    /**
     * {priority queue}
     * @param nums
     * @return
     */
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<Double>((a, b) -> b.compareTo(a));
        for (int num : nums) {
            pq.offer((double) num);
        }
        int res = 0;
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        double sum2 = 0.0;
        while (sum2 < sum / 2) {
            double x = pq.poll();
            sum2 += x / 2;
            pq.offer(x / 2);
            res++;
        }
        return res;
    }
}
