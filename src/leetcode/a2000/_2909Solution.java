package leetcode.a2000;

/**
 * 元素和最小的山形三元组
 * {prefix sum},{easy}
 */
public class _2909Solution {

    public int minimumSum(int[] nums) {

        int post[] = new int[nums.length];
        post[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            post[i] = Math.min(nums[i], post[i + 1]);
        }
        int prefix[] = new int[nums.length];
        prefix[0] = nums[0];
        int sum = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            prefix[i] = Math.min(prefix[i - 1], nums[i]);
            if (nums[i] > prefix[i - 1] && nums[i] > post[i + 1])
                sum = Math.min(sum, prefix[i - 1] + nums[i] + post[i + 1]);
        }

        return sum == Integer.MAX_VALUE ? -1 : sum;

    }
}
