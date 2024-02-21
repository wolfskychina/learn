package leetcode.a1000;
/**
 * 判断数组中删除一个元素能否使数组严格递增
 */
public class _1909Solution {
   
    public boolean canBeIncreasing(int[] nums) {

        int i=0;
        int count=0;
        while(i<nums.length-1){

            if(nums[i]<nums[i+1]){
                i++;
                continue;
            }else{

                if(count==1){
                    return false;
                }else{
                    count++;

                    // 需要判断逆序对中的每一个元素删除后能否符合条件
                    if(!(((i==0||nums[i]>nums[i-1])&&(i+2==nums.length||nums[i]<nums[i+2]))||
                    ((i==0||nums[i+1]>nums[i-1])&&(i+2==nums.length||nums[i+1]<nums[i+2]))))
                        return false;
                    i+=2;
                }
            }
        }

        return true;
    }
}
