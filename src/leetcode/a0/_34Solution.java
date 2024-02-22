package leetcode.a0;
/**
 * Find First and Last Position of Element in Sorted Array
 * 在已排序数组中寻找目标元素的最左侧和最右侧位置
 * 目标元素可能不存在
 * 
 * 类似的变体还有寻找目标元素的最左插入位置或者最右插入位置
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
        // 如果target不存在，返回的索引只有可能在0或者nums.length位置
        // 如果nums.length位置，那么不能直接访问，会越界
        // 所以先判断索引是否在nums.length位置
        if(leftIdx == nums.length|| target!=nums[leftIdx]) return targetRange;

        targetRange[0] = leftIdx;
        // 这里没有判断target是否存在是因为在前面寻找最左侧节点时已经判断过了
        // 此时返回的是最右侧的右边的位置
        targetRange[1] = extremeInsertionIndex(nums,target,false)-1;

        return targetRange;
    }
}
