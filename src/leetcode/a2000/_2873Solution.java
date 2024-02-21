package leetcode.a2000;
/**
 * 有序三元组的最大值
 * {easy}
 */
public class _2873Solution {
   
    public long maximumTripletValue(int[] nums) {
        long max = 0;
        boolean allneg = true;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0) {allneg = false;break;}
        }
        if(allneg) return 0;

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){

                    max = Math.max(max, (long)(nums[i]-nums[j])*nums[k]);

                }
            }
        }

        return max;
    }

    public long maximumTripletValue1(int[] nums) {
        long ans = 0;
        int maxDiff = 0, preMax = 0;
        for (int x : nums) {
            ans = Math.max(ans, (long) maxDiff * x);
            maxDiff = Math.max(maxDiff, preMax - x);
            preMax = Math.max(preMax, x);
        }
        return ans;
    }
}
