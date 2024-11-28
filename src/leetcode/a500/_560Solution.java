package leetcode.a500;

import java.util.HashMap;

/**
 * 数组中子数组的和等于k的子数组的个数
 */
public class _560Solution {

    /**
     * {prefix sum} 前缀和，速度比较慢
     * 
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {

        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < prefix.length; i++) {
            for (int j = i + 1; j < prefix.length; j++) {
                if (prefix[j] - prefix[i] == k)
                    res++;
            }
        }
        return res;
    }

    /**
     * 改用hashmap后速度快很多,时间复杂度on2降低到on
     * 空间复杂度仍然为线性，由数组改为hashmap，更复杂
     * {hashmap}
     * 
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        // 0比较特殊，如果单个数字==k的情况，也是一个合法解
        // 很容易落掉初始值0
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
