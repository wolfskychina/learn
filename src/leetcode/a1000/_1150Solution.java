package leetcode.a1000;
/**
 * 检查target是否是排好序的数组中占总数量大于一半的数
 * {binary search}
 */
public class _1150Solution {

    public boolean isMajorityElement(int[] nums, int target) {

        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        // 注意target不存在的时候，首末的判断是不一样的
        // 因为l初始值为0，但是r初始值为nums.length
        if ((r == 0 && nums[r] != target) || l == nums.length)
            return false;
        int left = l;
        l = 0;
        r = nums.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l - left > nums.length / 2;
    }

}
