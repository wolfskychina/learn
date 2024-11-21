package leetcode.a2000;

/**
 * 有序三元组的最大值
 * 三元组值的计算公式 (nums[i] - nums[j]) * nums[k]
 * {prefix sum},{easy}
 */
public class _2874Solution {
   
    public long maximumTripletValue(int[] nums) {
        
        int prefix [] = new int[nums.length];
        int post[] = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i] = Math.max(prefix[i-1],nums[i]);
        }
        post[post.length-1] = nums[nums.length-1];
        for(int i=post.length-2;i>=0;i--){
            post[i] = Math.max(post[i+1],nums[i]);
        }
        long res = 0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]<prefix[i-1]){
                res = Math.max(res, (long)(prefix[i-1]-nums[i])*post[i+1]);
            }
        }

        return res;
    }
}
