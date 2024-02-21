package leetcode.a0;
/**
 * {binary search}
 */
public class _35Solution {

    public int searchInsert(int[] nums, int target){
        int low =0;
        int high = nums.length;
        while(low<high){

            int mid = (high+low)/2;

            if(nums[mid]>=target){
                high=mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }


    public static void main(String[] args){
        _35Solution so = new _35Solution();
        int[] nums = {0,4,4,4,4,5,6,7,8,9,10};
        System.out.println(so.searchInsert(nums,4));
    }
}
