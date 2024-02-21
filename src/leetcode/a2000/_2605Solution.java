package leetcode.a2000;

/**
 * Given two arrays of unique digits nums1 and nums2,
 * return the smallest number that contains at least one digit
 * from each array.
 * 包含两个数位数组中各自至少一个数位的所能组成的最小数
 * {easy}
 */
public class _2605Solution {

    public int minNumber(int[] nums1, int[] nums2) {

        int min1 = 10;
        int min2 = 10;
        int[] count = new int[11];
        for (int i : nums1) {
            min1 = Math.min(min1, i);
            count[i]++;
        }
        for (int i : nums2) {
            min2 = Math.min(min2, i);
            count[i]++;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 2)
                return i;
        }
        return min1 < min2 ? 10 * min1 + min2 : 10 * min2 + min1;

    }
}
