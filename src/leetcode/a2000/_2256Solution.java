package leetcode.a2000;

/**
 * 最小平均差
 * 前后两端元素的平均值的差的最小值
 * {dp},{prefix sum}
 */
public class _2256Solution {

    public int minimumAverageDifference(int[] nums) {

        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        long prefix = 0;
        long resv = Long.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            long abs = Math
                    .abs(prefix / (i + 1) - ((nums.length - i - 1) == 0 ? 0 : (sum - prefix) / (nums.length - i - 1)));
            if (abs < resv) {
                resv = abs;
                idx = i;
            }
        }
        return idx;

    }
}
