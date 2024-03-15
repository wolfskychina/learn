package leetcode.a2000;

import java.util.HashSet;
import java.util.Set;
/**
 * 找到两个数组中的公共元素
 * @param nums1
 * @param nums2
 * @return
 */
public class _2956Solution {
   
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i:nums1){
            set1.add(i);
        }
        for(int i:nums2){
            set2.add(i);
        }
        int count1 = 0;
        for(int i:nums1){
            if(set2.contains(i)){
                count1++;
            }
        }
        int count2 = 0;
        for(int i:nums2){
            if(set1.contains(i))
                count2++;
        }
        return new int[]{count1,count2};
    }

    /**
     * 需要额外的一个状态-1，用来只统计一次nums1里面的n在nums2中出现的次数
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] findIntersectionValues1(int[] nums1, int[] nums2) {
        int[] cnts = new int[101];
        for( int n : nums1 ) cnts[n] ++;
        int[] ans = {0, 0};
        for( int n : nums2){
            if( cnts[n] == 0) continue;
            if( cnts[n] != -1 ) ans[0] += cnts[n];
            cnts[n] = -1;
            ans[1] ++;
        }
        return ans;
    }
}
