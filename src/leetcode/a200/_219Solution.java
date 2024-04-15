package leetcode.a200;

import java.util.HashSet;
import java.util.Set;

/**
 * 寻找数组中相邻的k个元素中是否有重复的元素
 * {easy}
 */
public class _219Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // size of window = k+1;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;

    }
}
