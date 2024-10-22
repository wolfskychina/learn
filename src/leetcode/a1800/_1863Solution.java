package leetcode.a1800;
/**
 * 所有子集的异或总和
 * 解空间比较大,整个解空间搜索
 * {backtrace}
 */
public class _1863Solution {

    private int sum = 0;

    public int subsetXORSum(int[] nums) {
        backtrack(nums, 0, 0);
        return sum;
    }

    /**
     * 解空间指数增长
     * @param nums
     * @param idx
     * @param tmp
     */
    private void backtrack(int[] nums, int idx, int tmp) {

        if (idx == nums.length) {
            sum += tmp;
            return;
        }

        backtrack(nums, idx + 1, tmp ^ nums[idx]);
        backtrack(nums, idx + 1, tmp);

    }

}