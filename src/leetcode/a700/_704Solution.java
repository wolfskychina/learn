package leetcode.a700;

/**
 * 有序数组的二分查找
 */
public class _704Solution {

    /**
     * {binary search}
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length;
        while (l < r) {

            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        // {TODO}注意target不在数组中的时候的判断条件，不能直接返回l
        return (l == nums.length || nums[l] != target) ? -1 : l;
    }

}
