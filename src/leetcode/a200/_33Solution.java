package leetcode.a200;

public class _33Solution {

    public int search(int[] nums, int target){
        if(nums.length == 0) return -1;
        int start = 0, end = nums.length-1;
        while(start<end){
            int mid = (start+end)/2;
            // 基于一个事实，无论如何将一个有序数列分成两段并调换两段的前后顺序
            // 将新的数列从中平均分成两段，至少有一段是单调有序的
            if(nums[mid]>nums[end]){
                if(target>nums[mid]||target<=nums[end]){
                start = mid +1;
                }else{
                    end = mid;
                }
            }else{
                if(target >nums[mid] && target<=nums[end]){
                    start = mid+1;
                }else{
                    end =mid;
                }
            }
        }

        if(start == end && target!=nums[start]) return -1;
        return start;
    }

    public static void main(String[] args){

        _33Solution so = new _33Solution();
        int [] nums = {1,3,5,7,10,10,10,10,10,14,18,19,33};
        System.out.println(so.search(nums,10));
    }
}
