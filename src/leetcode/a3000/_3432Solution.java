package leetcode.a3000;

/**
 * 统计元素和的差值为偶数的数组的划分方案
 * {Math}
 */
public class _3432Solution {

    /**
     * 划分每移动一位都不影响奇偶性，从而推断出
     * 任意的划分都不影响奇偶性
     * @param nums
     * @return
     */
    public int countPartitions(int[] nums) {

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        // sum -= 2 * nums[0];
        if (sum % 2 == 0) {
            return nums.length - 1;
        } else {
            return 0;
        }
    }
}
