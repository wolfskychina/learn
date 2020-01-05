package leetcode.array;

public class _35Solution {

    public int searchInsert(int[] nums, int target){
        int low =0;
        int high = nums.length;
        while(low<high){
            System.out.println("low is :"+low);
            System.out.println("high is :"+high);
            int mid = (high+low)/2;
            System.out.println("mid is :"+mid);

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
        int[] nums = {0,1,2,3,4,5,6,7,8,9,10};
        System.out.println(so.searchInsert(nums,4));
    }
}
