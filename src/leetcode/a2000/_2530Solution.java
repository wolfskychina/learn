package leetcode.a2000;

import java.util.PriorityQueue;
/**
 * 执行k次操作后能获得的最大和
 * 每次选取最大值后，这个值会变成原来的1/3
 */
public class _2530Solution {
   
    /**
     * {PriorityQueue}
     * @param nums
     * @param k
     * @return
     */
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int num : nums) {
            q.offer(num);
        }
        long ans = 0;
        for (int i = 0; i < k; ++i) {
            int x = q.poll();
            ans += x;
            // 取地板操作
            q.offer((x + 2) / 3);
        }
        return ans;
    }
}
