package leetcode.a1100;

import java.util.HashMap;
import java.util.Map;
/**
 * 同积元组
 * a*b=c*d的数量
 */
public class _1726Solution {
   
    /**
     * {hashmap}每一对乘积相同的二元组可以产生8组abcd的排列
     * @param nums
     * @return
     */
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int key = nums[i] * nums[j];
                cnt.put(key, cnt.getOrDefault(key, 0) + 1);
            }
        }
        int ans = 0;
        for (Integer v : cnt.values()) {
            ans += v * (v - 1) * 4;
        }
        return ans;
    }

}
