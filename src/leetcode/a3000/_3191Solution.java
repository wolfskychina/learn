package leetcode.a3000;

/**
 * 只允许对连续三位数字进行反转，
 * 问是数组全部为1所需要的最少反转次数，
 * 无法做到的话返回-1
 */
public class _3191Solution {

    /**
     * {greedy},{dp}
     * 如果某一位是0，那么必须反转
     * 问题转换成剩下的n-1位数字的子问题
     * 剩下最后三位的时候，如果最后两位不是1，那么无法再反转了
     * @param nums
     * @return
     */
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) { // 必须操作
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ans++;
            }
        }
        return nums[n - 2] != 0 && nums[n - 1] != 0 ? ans : -1;
    }
}
