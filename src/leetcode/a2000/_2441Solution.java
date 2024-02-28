package leetcode.a2000;

import java.util.HashSet;
import java.util.Set;
/**
 * 与对应负数同时存在的最大正整数
 * {easy}
 */
public class _2441Solution {
   
    public int findMaxK(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            if(i<0){
                set.add(i);
            }
        }
        int max =-1;
        for(int i:nums){

            if(i>max&&set.contains(-i)){
                max =i;
            }
        }
        return max;
    }
}
