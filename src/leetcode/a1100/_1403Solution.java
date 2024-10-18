package leetcode.a1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 非递增顺序的最小子序列
 * {easy}
 */
public class _1403Solution {
   
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int prefix[] = new int[nums.length+1];
        for(int i=1;i<prefix.length;i++){
            prefix[i] = prefix[i-1]+nums[nums.length-i];
        }
        int sum = prefix[prefix.length-1];
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<prefix.length;i++){
            res.add(nums[nums.length-i]);
            if(prefix[i]>sum-prefix[i])
                return res;
        }
        return res;
    }
}
