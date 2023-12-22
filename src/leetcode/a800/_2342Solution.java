package leetcode.a800;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * 各位数字和相同的数字的最大和
 */
public class _2342Solution {
   
    /**
     * {priority queue}
     * @param nums
     * @return
     */
    public int maximumSum(int[] nums) {

        Map<Integer, Queue<Integer>> map = new HashMap<>();
        
        for(int i:nums){
            int digitsum = getdigitsum(i);
            Queue<Integer> q = map.getOrDefault(digitsum, new PriorityQueue<>((o1,o2)->o2-o1));
            q.offer(i);
            map.put(digitsum,q);
        }
        int max =-1;
        for(Queue<Integer> q:map.values()){
            if(q==null||q.size()<2) continue;
            max = Math.max(max, q.poll()+q.poll());
        }

        return max;
    }

    private int getdigitsum(int i) {

        int sum =0;
        while(i !=0){
            sum+=i%10;
            i/=10;
        }
        return sum;
    }

    /**
     * 巧妙使用数组保存位数之和相同的最大数
     * 整数各位数字的和最大不会超过100
     * @param nums
     * @return
     */
    public int maximumSum1(int[] nums) {
        int ans = -1;
        int[] val = new int[100];
        for (int x : nums) {
            int t=x;
            int cur = 0;
            while (t != 0) {
                cur += t % 10;
                t /= 10;
            }
            if (val[cur] != 0) {
                ans = Math.max(ans, x + val[cur]);
            }
            val[cur] = Math.max(x, val[cur]);
        }
        return ans;
    }
}
