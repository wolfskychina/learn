package leetcode.a2000;

/**
 * 正负整数的数量
 * {binary search}
 * {easy}
 */
public class _2529Solution {

    public int maximumCount(int[] nums) {

        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        int pos = nums.length - r;
        l = 0;
        r = nums.length;

        while (l < r) {

            int mid = (l + r) / 2;
            if (nums[mid] >= 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int neg = r;
        return Math.max(pos, neg);
    }
}
