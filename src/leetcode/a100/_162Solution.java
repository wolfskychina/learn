package leetcode.a100;

/**
 * 寻找数组中的峰值
 * 峰值指比左右两边大的数值
 * 未必是最大值
 * 限制：相邻两个元素大小一定不相同
 * {binary search}
 */
public class _162Solution {
    
    /**
     * 二分查找
     * 寻找切点，使用二分查找更快收敛
     * 类似的可以寻找局部最小值
     * 因为题目限制了相邻元素一定不相同，否则用二分不一定能找到峰值
     */
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            // 这样比较不会溢出，如果是mid-1的话，就可能溢出，比如(1,2)low=1，hi=2
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
