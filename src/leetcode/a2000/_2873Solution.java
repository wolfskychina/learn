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

    /**
     * 一趟循环的遍历
     */
    public long maximumTripletValue1(int[] nums) {
        long ans = 0;
        int maxDiff = 0, preMax = 0;
        for (int x : nums) {
            // 在第三个元素时计算第一个最大值
            ans = Math.max(ans, (long) maxDiff * x);
            // maxDiff在遍历完第二个元素后有值
            maxDiff = Math.max(maxDiff, preMax - x);
            // preMax在遍历完第一个元素后有值
            preMax = Math.max(preMax, x);
        }
        return ans;
    }
}
