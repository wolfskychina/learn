package leetcode.a2000;

/**
 * 拼接数组的最大分数
 * {dp}两个数组，交换同样位置的区间数据后，所能形成的数组和的最大值
 */
public class _2321Solution {

    /**
     * 将两个数组对应位置做差后，问题转换为求差分数组的最大子数组
     * @param nums1
     * @param nums2
     * @return
     */
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(solve(nums1, nums2), solve(nums2, nums1));
    }

    int solve(int[] nums1, int[] nums2) {
        int s1 = 0, maxSum = 0;
        for (int i = 0, s = 0; i < nums1.length; ++i) {
            s1 += nums1[i];
            s = Math.max(s + nums2[i] - nums1[i], 0);
            maxSum = Math.max(maxSum, s);
        }
        return s1 + maxSum;
    }
}
