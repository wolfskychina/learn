package leetcode.a500;
/**
 * 一个排好序的数列，其中除了一个元素出现过一次，其他元素均出现了两次
 * 求这个出现过一次的元素
 * {binary search}
 */
public class _540Solution {

    /**
     * 二分查找，单个元素出现前的元素满足偶数位元素和下一个元素相等，
     * 从单个元素开始以及后面的元素，不满足偶数位元素和下一个元素相等
     * 
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length / 2;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[2 * mid] == nums[2 * mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[2 * l];

    }
}
