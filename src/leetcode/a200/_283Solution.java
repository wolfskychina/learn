package leetcode.a200;

/**
 * 将数组中的0移动到末尾，并且保留其他数字的相对顺序
 * {two pointers}
 */
public class _283Solution {
    /**
     * 双指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {

            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        while (slow < nums.length) {
            nums[slow++] = 0;
        }

    }
}
