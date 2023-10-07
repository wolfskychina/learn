package leetcode.a300;
/**
 * 396. Rotate Function
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
 * 转换函数，每次乘的时候数组元素向右轮转一位
 * 求所有的轮转生成的fk中的最大值
 */
public class _396Solution {

    /**
     * f(k)和f(k-1)的递推规律
     * @param nums
     * @return
     */
    public int maxRotateFunction(int[] nums) {

        int tmpsum = 0;
        for (int i : nums) {
            tmpsum += i;
        }
        int max = Integer.MIN_VALUE;
        int f = 0;
        for (int i = 0; i < nums.length; i++) {
            f += i * nums[i];
        }
        max = Math.max(max, f);
        for (int i = 1; i < nums.length; i++) {

            f += tmpsum - nums[nums.length - i] * nums.length;
            max = Math.max(max, f);
        }

        return max;

    }
}
