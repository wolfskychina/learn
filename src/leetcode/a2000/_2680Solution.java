package leetcode.a2000;

/**
 * 对于数组中的任意元素，总共可以做k次x2的操作
 * 问能形成最大的or值
 */
public class _2680Solution {

    /**
     * {bit manipulation},{greedy},{prefix sum}
     * 将x2分配给多个字，不如分配给同一个数，让位数尽可能多
     * 采用前后缀的方式，遍历单个数字k次x2
     * @param nums
     * @param k
     * @return
     */
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        var suf = new int[n + 1];
        for (int i = n - 1; i > 0; i--)
            suf[i] = suf[i + 1] | nums[i];
        long ans = 0;
        for (int i = 0, pre = 0; i < n; i++) {
            ans = Math.max(ans, pre | ((long) nums[i] << k) | suf[i + 1]);
            pre |= nums[i];
        }
        return ans;
    }
}
