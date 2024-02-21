package leetcode.a1000;
/**
 * 所有子集的异或总和
 * {backtrace}
 */
public class _1863Solution {

    private int sum = 0;

    public int subsetXORSum(int[] nums) {
        backtrack(nums, 0, 0);
        return sum;
    }

    private void backtrack(int[] nums, int idx, int tmp) {

        if (idx == nums.length) {
            sum += tmp;
            return;
        }

        backtrack(nums, idx + 1, tmp ^ nums[idx]);
        backtrack(nums, idx + 1, tmp);

    }

}
