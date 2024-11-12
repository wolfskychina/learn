package leetcode.a1700;
/**
 * 只允许一次元素自乘操作的数组的最大子数组的和
 * TODO
 */
public class _1746Solution {

    /**
     * {dp}
     * @param nums
     * @return
     */
    public int maxSumAfterOperation(int[] nums) {

        int dp1 = 0, dp2 = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp1 = Math.max(dp1 + nums[i], dp2 + nums[i] * nums[i]);// dp1表示之前有平方操作的和的最大值
            dp2 = Math.max(nums[i] + dp2, 0);// dp2表示之前一直没有平方操作的和的最大值，而且dp2延伸到当前元素的连续的子数组窗口
            // dp2产生负值表示子数组和累计到现在变成负值，没有意义，从头开始找子数组
            max = Math.max(dp1, max);
        }
        return max;
    }
}
