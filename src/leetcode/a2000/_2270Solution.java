package leetcode.a2000;

/**
 * 分割数组，使得前面部分之和大于或者等于后面部分和的分割有多少种
 * {prefix sum},{easy}
 */
public class _2270Solution {

    public int waysToSplitArray(int[] nums) {

        long sum = 0L;
        for (int i : nums) {
            sum += i;
        }
        long prefix = 0L;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            prefix += nums[i];
            sum -= nums[i];
            if (prefix >= sum)
                res++;
        }
        return res;
    }
}
