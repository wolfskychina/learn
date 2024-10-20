package leetcode.a3000;

/**
 * 使二进制数组全部为1的最少操作次数
 * 每次操作都会使当前位和右侧所有位的数字反转
 * {greedy},{dp}
 */
public class _3192Solution {

    /**
     * 记录之前的反转次数，如果之前反转了偶数次，那么当前位和最初一样
     * 如果反转了奇数次，那么和最初相反
     * 然后考虑当前位是否是0，如果是0，那么必须反转，总次数加1
     * 如果是1，那么不需要反转，总次数不变
     * @param nums
     * @return
     */
    public int minOperations(int[] nums) {
        int k = 0;
        for (int x : nums) {
            if (x == k % 2) { // 必须操作
                k++;
            }
        }
        return k;
    }

    /**
     * 根据前一位数字和当前位数字的相对关系，考虑所有可能情况
     * 能够得出，当前数字是否需要反转只和前一位有关系
     * @param nums
     * @return
     */
    public int minOperations1(int[] nums) {
        int ans = nums[0] ^ 1;
        for (int i = 1; i < nums.length; i++) {
            ans += nums[i - 1] ^ nums[i];
        }
        return ans;
    }
}
