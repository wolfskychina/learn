package leetcode.a500;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中是否存在和是k的整数倍的子数组
 * {subarray},{prefix sum}
 */
public class _523Solution {
   
    /**
     * 0是k的整数倍
     * 用前缀和快速计算子数组的和
     * c = a - b ，如果c%k == 0 那么 a%k - b%k ==0
     * 也就是说 a%k == b%k
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            // 只需要计算和保留余数即可
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }


}
