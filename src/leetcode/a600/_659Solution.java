package leetcode.a600;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 非递减的整数序列能否拆成全部长度不少于3的递增子序列，且子序列严格递增1
 */
public class _659Solution {

    /**
     * {Priority Queue},{minimum heap},{greedy}
     * 每次都尝试往末尾符合条件且元素数量最少的队列里面添加
     * 满足一种贪心性质：如果两个子序列满足条件且可以合并，那么合并之后仍然满足条件
     * 
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<Integer>());
            }
            if (map.containsKey(x - 1)) {
                int prevLength = map.get(x - 1).poll();
                if (map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
                map.get(x).offer(prevLength + 1);
            } else {
                map.get(x).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }

    /**
     * {dp}很快的dp方案
     * dp1 为以 prev 结尾的长度为 1的子序列数目， dp2 为以 prev结尾的长度为 2 的子序列数目， dp3 为以 prev 结尾的长度 ≥3
     * 的子序列数目
     * 
     * @param nums
     * @return
     */
    public boolean isPossible1(int[] nums) {
        int n = nums.length;
        int dp1 = 0; // 长度为1的子序列数目
        int dp2 = 0; // 长度为2的子序列数目
        int dp3 = 0; // 长度>=3的子序列数目
        int idx = 0;
        int start = 0; // 起始位置

        while (idx < n) {
            start = idx; // 重新将起始位置赋值
            int x = nums[idx];
            while (idx < n && nums[idx] == x) {
                idx++;
            }
            int cnt = idx - start;

            if (start > 0 && x != nums[start - 1] + 1) { // 对于nums[idx] != nums[idx - 1] + 1，说明当前整数无法加入到以nums[idx-1]
                                                         // 为结尾的序列中
                if (dp1 + dp2 > 0) { // 如果 dp1+dp2>0，说明有些长度≤2的序列无法被满足，因此不存在相应的分割方案。
                    return false;
                } else { // 否则，此前的序列全部作废
                    dp1 = cnt;
                    dp2 = dp3 = 0;
                }
            } else { // 对于nums[idx] == nums[idx - 1] +
                     // 1，说明当前整数可以加入到所有以nums[idx-1]为结尾的序列中。假设数组中x的数目为cnt：
                if (dp1 + dp2 > cnt) { // 首先，根据贪心的策略，我们要尽可能地先把 x 添加到长度≤2 的子序列中，从而尽可能地保证子序列的长度都≥3。如果x的数量不够，说明不存在相应的分割方案。
                    return false;
                }
                int left = cnt - dp1 - dp2; // 此时 还剩下left = cnt -dp1 -dp2个 nums[idx-1](x)
                int keep = Math.min(dp3, left); // 尽量将余下的left个整数添加到长度≥3的子序列中
                // 最后，更新 dp1,dp2,dp3的取值
                dp3 = keep + dp2;
                dp2 = dp1;
                dp1 = left - keep; // 如果还有剩余，才将开启对应数量的新序列。新序列的数目等于left−keep。
            }
        }

        return dp1 == 0 && dp2 == 0;
    }

}
