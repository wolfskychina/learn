package leetcode.a2000;

/**
 * 按位或所能得到的最大值为n，
 * 数组中选取子集进行或操作能组成n的总的方案数
 * {bit manipulation}
 */
public class _2044Solution {

    int res = 0;

    public int countMaxOrSubsets(int[] nums) {

        int mask = 0;
        for (int i : nums) {
            mask |= i;
        }
        backtrack(0, mask, 0, nums);
        return res;
    }

    private void backtrack(int accu, int mask, int i, int[] nums) {

        if (i == nums.length) {

            if (accu == mask)
                res++;
            return;
        }
        backtrack(accu, mask, i + 1, nums);
        backtrack(accu | nums[i], mask, i + 1, nums);
    }
}
