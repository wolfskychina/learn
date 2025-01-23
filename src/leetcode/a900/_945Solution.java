package leetcode.a900;

import java.util.Arrays;

/**
 * 每一步可以使数组中的一个数+1
 * 问最少需要多少步，可以使数组中的所有数都不相等
 * {math},{greedy}
 */
public class _945Solution {

    /**
     * 排序后使用贪心规则，需要40ms
     * 
     * @param nums
     * @return
     */
    public int minIncrementForUnique(int[] nums) {

        Arrays.sort(nums);
        int idx = nums[0] + 1;
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] <= idx) {
                sum += idx - nums[i];
            }
            idx = Math.max(idx, nums[i]) + 1;

        }

        return sum;
    }

    /**
     * 使用计数然后贪心，只需要4ms，速度快了10倍
     * 不断将问题往后推，思想非常巧妙
     * {counting}
     * 
     * @param nums
     * @return
     */
    public int minIncrementForUnique1(int[] nums) {
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);
        // 这里注意arr的长度，因为最大值的时候也可能是非唯一的
        // 还需要接着往后移动
        int[] arr = new int[max + nums.length];
        for (int num : nums)
            arr[num]++;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 1)
                continue;
            int duplicate = arr[i] - 1;
            arr[i + 1] += duplicate;
            res += duplicate;
        }
        return res;
    }

    public static void main(String[] args) {

        _945Solution so = new _945Solution();
        int[] nums = { 3, 2, 1, 2, 1, 7 };
        so.minIncrementForUnique(nums);
    }
}
