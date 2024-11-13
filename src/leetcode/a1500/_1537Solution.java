package leetcode.a1500;

/**
 * 两个升序排列的非重复数的整数数组
 * 一个指针从头开始遍历两个数组（可以从nums1开始也可以从nums2开始）
 * 如果遇到两个数组中相同的数，那么下一步可以切换到相邻数组的下一个数字
 * 相同的数只计算一次
 */
public class _1537Solution {

    /**
     * 
     * 符合贪心条件，两个相同数之间的两个片段，哪个总和大就用哪个
     * 切换路径的时候没有产生成本，代价为0
     * {greedy}
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        long res = 0;
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res += (Math.max(sum1, sum2) + nums1[i]);
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                sum1 += nums1[i];
                i++;
            } else {
                sum2 += nums2[j];
                j++;
            }
        }
        while (i < nums1.length) {
            sum1 += nums1[i];
            i++;
        }
        while (j < nums2.length) {
            sum2 += nums2[j];
            j++;
        }
        res += Math.max(sum1, sum2);
        return (int) (res % ((int) Math.pow(10, 9) + 7));
    }

    /**
     * {dp}
     * dp1表示当前索引选nums1元素时的最大值
     * dp2表示当前索引选nums2元素时的最大值
     * 两边待比较元素相等的时候，前面的路径既可以是1也可以是2
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxSum1(int[] nums1, int[] nums2) {

        long dp1 = 0;
        long dp2 = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] < nums2[idx2]) {
                dp1 += nums1[idx1++];

            } else if (nums1[idx1] > nums2[idx2]) {
                dp2 += nums2[idx2++];
            } else {
                dp1 = Math.max(dp1, dp2) + nums1[idx1];
                dp2 = dp1;
                idx1++;
                idx2++;
            }
        }
        while (idx1 < nums1.length) {
            dp1 += nums1[idx1++];
        }
        while (idx2 < nums2.length) {
            dp2 += nums2[idx2++];
        }
        int MOD = (int) 1e9 + 7;

        return (int) (Math.max(dp1, dp2) % MOD);
    }
}
