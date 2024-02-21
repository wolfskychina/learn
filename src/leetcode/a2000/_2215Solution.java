package leetcode.a2000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 找出两个数组中不同的元素
 * {easy}
 */
public class _2215Solution {
   
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i:nums1){
            set1.add(i);
        }
        for(int i:nums2){
            set2.add(i);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i:set1){
            if(!set2.contains(i)){
                list1.add(i);
            }
        }
        for(int i:set2){
            if(!set1.contains(i)){
                list2.add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        return res;
    }
}
