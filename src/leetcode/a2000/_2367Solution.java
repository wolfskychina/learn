package leetcode.a2000;

import java.util.HashSet;
import java.util.Set;

/**
 * 算术三元组的数量
 */
public class _2367Solution {
   
    /** */
    public int arithmeticTriplets(int[] nums, int diff) {

        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int count=0;
        for(int i:nums){
            if(set.contains(i+diff)&&set.contains(i+2*diff))
            count++;
        }
        return count;
    }

    /**
     * 计数排序
     * @param nums
     * @param diff
     * @return
     */
    public int arithmeticTriplets1(int[] nums, int diff) {
        int[] ints = new int[201];
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int n = nums[i];
            if (n + diff * 2 <= 200 && ints[n + diff] != 0 && ints[n + diff * 2] != 0) {
                count++;
            }
            ints[n] ++;
        }
        return count;
    }
}
