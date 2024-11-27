package leetcode.a2000;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有三元组之和的mod值为d的个数
 * {hashmap}
 * 空间换时间
 */
public class _2964Solution {

    public int divisibleTripletCount(int[] nums, int d) {
        int triplets = 0;
        // counts保存i之前的所有二元组的和的mod值
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        int b = nums.length;
        for (int i = 0; i < b; i++) {
            int remainder = nums[i] % d;
            // 如果i是第三个数，那么需要前两个数的和是prevRemainder
            int prevRemainder = (d - remainder) % d;
            // 对于i作为第三元素，前面满足二元组之和为prevRemainder的个数
            triplets += counts.getOrDefault(prevRemainder, 0);
            // i遍历完，本身作为第二个元素更新二元组之和的缓存
            for (int j = 0; j < i; j++) {
                int sum = (nums[j] + nums[i]) % d;
                counts.put(sum, counts.getOrDefault(sum, 0) + 1);
            }
        }
        return triplets;
    }

}
