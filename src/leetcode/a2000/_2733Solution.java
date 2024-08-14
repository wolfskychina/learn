package leetcode.a2000;

/**
 * 数组中既不是最大也不是最小的值
 * {easy}
 */
public class _2733Solution {

    public int findNonMinOrMax(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : nums) {

            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        for (int i : nums) {

            if (i != max && i != min)
                return i;
        }
        return -1;
    }

    public int findNonMinOrMax1(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {

            // 是否之内
            int n = nums[i];
            if (min < n && n < max) {
                return n;
            }

            int old_min = min;
            int old_max = max;
            min = Math.min(min, n);
            max = Math.max(max, n);

            // 左边界是否之内
            if (min < old_min && old_min < max) {
                return old_min;
            }
            // 右边界是否之内
            if (min < old_max && old_max < max) {
                return old_max;
            }

            // System.out.println(min + " " + max);

        }

        return -1;
    }
}
