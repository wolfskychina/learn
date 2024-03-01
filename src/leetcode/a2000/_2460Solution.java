package leetcode.a2000;
/**
 * 对数组执行操作
 * {easy}
 */
public class _2460Solution {

    public int[] applyOperations(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                nums[l++] = nums[r];

            }
            r++;
        }
        while (l < nums.length) {
            nums[l++] = 0;
        }

        return nums;
    }
}
