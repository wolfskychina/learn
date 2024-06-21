package leetcode.a500;

import java.util.HashMap;
import java.util.Map;
/**
 * 由0和1组成的数组中,最长的0和1数量相等的子数组的长度
 */
public class _525Solution {


    /**
     * 将0变成-1，满足条件的子数组元素之和为0，对应的两个前缀序列和的差为0
     * 
     * {subarray},{prefix sum}
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {

        // ie. [0,1]
        if (nums[0] == 0)
            nums[0] = -1;
        int count = 0;
        count = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        // 前缀和为0的时候比较特殊，如果以idx=0开头的子数组前缀和为0
        // 也需要统计进来
        // -1这个是伪指针
        map.put(0,-1);
        map.put(count, 0);
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
            count += nums[i];
            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }

        }

        return max;

    }
}
