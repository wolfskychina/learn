package leetcode.a800;
/**
 * 按照奇偶排序数组
 * {easy}
 */
public class _922Solution {

    public int[] sortArrayByParityII(int[] nums) {

        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {

            while (i < nums.length && nums[i] % 2 == 0) {
                i += 2;
            }
            while (j < nums.length && nums[j] % 2 == 1) {
                j += 2;
            }
            if (i < nums.length && j < nums.length) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        return nums;
    }
}
