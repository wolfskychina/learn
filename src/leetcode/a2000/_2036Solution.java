package leetcode.a2000;

/**
 * 跟1911类似，这个是子数组的最大交替和
 * {dp}
 */
public class _2036Solution {

    public long maximumAlternatingSubarraySum(int[] nums) {
        int n = nums.length;
        long ans = nums[0];
        long sumAdd = nums[0];
        long sumMinus = 0;
        for (int i = 1; i < n; i++) {
            // 偶数位置可以继续延长也可以开始新的子数组
            long sumAddCur = Math.max(sumMinus + nums[i], nums[i]);
            // 奇数位置只能延长
            sumMinus = sumAdd - nums[i];
            sumAdd = sumAddCur;
            ans = Math.max(ans, Math.max(sumAdd, sumMinus));
        }
        return ans;
    }
}
