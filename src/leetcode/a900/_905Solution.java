package leetcode.a900;
/**
 * 按照奇偶特性排序数组
 */
public class _905Solution {

    /**
     * {easy},{two pointers}
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {

        int l=0;
        for(int i=0;i<nums.length;i++){

            if(nums[i]%2==0){
                int tmp = nums[i];
                nums[i] = nums[l];
                nums[l] = tmp;
                l++;
            }

        }

        return nums;

    }
}
