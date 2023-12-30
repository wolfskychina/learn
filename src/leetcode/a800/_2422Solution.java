package leetcode.a800;
/**
 * 能使得数组变成回文数组的最少的操作
 * 每次操作使相邻的两个数组中的数合并成两数之和
 */
public class _2422Solution {
   
    /**
     * {greedy},{two pointers}很难想到是符合贪心规则
     * 双指针从两端开始比较，如果两个数不相等，那么小的那个数一定需要合并
     * @param nums
     * @return
     */
    public int minimumOperations(int[] nums) {

        int count=0;
        int l=0;
        int r=nums.length-1;
        while(l<r){

            if(nums[l]==nums[r]){
                l++;
                r--;
            }else if(nums[l]>nums[r]){
                nums[r-1]+=nums[r];
                r--;
                count++;
            }else{
                nums[l+1]+=nums[l];
                l++;
                count++;
            }
            
        }
        return count;
    }
}
