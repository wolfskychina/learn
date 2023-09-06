package leetcode.a100;

/**
 * 一个有序数组被从中间分开前后两段调换了顺序
 * 找到数组最小元素的位置
 */
public class _153Solution {
   
    // 二分查找
    public int findMin(int[] nums) {
        
        int low =0;
        int high =nums.length-1;
        int mid = 0;
        
        while(low<high){
            
            mid = low + (high-low)/2;
            
            if(nums[mid]>nums[high]){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        
        return nums[high];
    }
}
