package leetcode.a700;
/**
 * 至少是其他数字两倍的最大数
 */
public class _747Solution {
   /**
    * {easy}
    * @param nums
    * @return
    */
    public int dominantIndex(int[] nums) {

        int max = -1;
        int lmax = -1;
        int idx = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                lmax= max;
                max =nums[i];
                idx =i;

            }else if(nums[i]>lmax){
                lmax = nums[i];
            }
        }

        return max>=2*lmax?idx:-1;
    }
}
