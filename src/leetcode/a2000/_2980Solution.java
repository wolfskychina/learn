package leetcode.a2000;
/**
 * 检查两个数字的按位或是否存在后缀0
 * {easy}
 */
public class _2980Solution {
   
    public boolean hasTrailingZeros(int[] nums) {

        for(int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++){

                if(nums[i]%2==0&&nums[j]%2==0)
                    return true;
            }
        }
        return false;
    }

    public boolean hasTrailingZeros1(int[] nums) {
        int count = 0;
        for(int num : nums){
            if(num % 2 == 0){
                count++;
                if(count > 1){
                    return true;
                }
            }
        }
        return false;
    }
}
