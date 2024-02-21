package leetcode.a0;
/**
 * {binary search}
 */
public class _34Solution {

    private int extremeInsertionIndex(int[] nums,int target, boolean left){
        int lo = 0;
        int hi = nums.length;

        while(lo<hi){
            int mid = (lo+hi)/2;
            if(nums[mid]>target || (left && target ==nums[mid])){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target){

        int[] targetRange ={-1,-1};
        int leftIdx = extremeInsertionIndex(nums,target,true);
        if(leftIdx == nums.length|| target!=nums[leftIdx]) return targetRange;

        targetRange[0] = leftIdx;
        // 这里没有判断target是否存在是因为在前面寻找最左侧节点时已经判断过了
        targetRange[1] = extremeInsertionIndex(nums,target,false)-1;

        return targetRange;
    }
}
