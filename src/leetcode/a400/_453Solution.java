package leetcode.a400;

/**
 * 453. Minimum Moves to Equal Array Elements
 * 一个数字数组，每次操作都是将数组中n-1的数加1
 * 问最少多少次操作后，能使数组中的数字全部相等
 */
public class _453Solution {

    /**
     * 将数组中n-1的数加一就相当于将数组中的一个数-1
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            min = Math.min(min, nums[i]);
        }
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res += nums[i] - min;
        }

        return res;

    }
}
