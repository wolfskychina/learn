package leetcode.a2000;
/**
 * 数组左右元素和的差值
 * {easy}
 * {prefix sum}
 */
public class _2574Solution {

    public int[] leftRightDifference(int[] nums) {

        int prefix[] = new int[nums.length];
        int postfix[] = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] + nums[i + 1];
        }
        int res[] = new int[nums.length];

        for (int i = 0; i < res.length; i++) {

            res[i] = Math.abs(prefix[i] - postfix[i]);

        }

        return res;
    }
}
