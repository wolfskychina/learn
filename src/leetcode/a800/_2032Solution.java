package leetcode.a800;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 找出三个数组中至少在两个数组中出现过的数字
 */
public class _2032Solution {
   
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();

        for(int i:nums1){
            set1.add(i);
        }
        for(int i:nums2){
            set2.add(i);
        }
        for(int i:nums3)
            set3.add(i);
        
        int[] count = new int[101];
        for(int i:set1){
            count[i]++;
        }
        for(int i:set2){
            count[i]++;
        }
        for(int i:set3){
            count[i]++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<count.length;i++){
            if(count[i]>1)
                res.add(i);
        }
        return res;
    }

    /**
     * arr[i]存储的是状态而不是数量
     * @param nums1
     * @param nums2
     * @param nums3
     * @return
     */
     public List<Integer> twoOutOfThree1(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[101];
        
        for (int i : nums1) {
            arr[i] = 1;
        }
        for (int i : nums2) {
            if (arr[i] == 1 || arr[i] == 3) {
                // 3表示在nums1和nums2中都出现过
                arr[i] = 3;
            } else {
                // 用状态2表示第一次在nums2出现
                arr[i] = 2;
            }
        }

        for (int i : nums3) {
            if (arr[i] == 1 || arr[i] == 2) {
                arr[i] = 3;
            }
        }

        for (int i = 1; i < 101; i++) {
            if (arr[i] > 2) {
                ans.add(i);
            }
        }
        return ans;
    }
}
