package leetcode.a2000;

/**
 * 对数组1中元素做特定修改使得数组1最终和数组2相等的最少修改次数
 * 特定修改指每次将nums1中的一个元素增加k，另外一个元素同时减少k
 * {math}
 */
public class _2541Solution {

    /**
     * 注意增量k是0的情况需要特殊考虑
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public long minOperations(int[] nums1, int[] nums2, int k) {

        long pos = 0;
        long neg = 0;
        if (k == 0) {
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] != nums2[i])
                    return -1;
            }
            return 0;
        }
        for (int i = 0; i < nums1.length; i++) {

            if (nums1[i] > nums2[i]) {
                if ((nums1[i] - nums2[i]) % k == 0) {
                    pos += (nums1[i] - nums2[i]) / k;
                } else {
                    return -1;
                }
            } else {
                if ((nums2[i] - nums1[i]) % k == 0) {
                    neg += (nums2[i] - nums1[i]) / k;
                } else {
                    return -1;
                }
            }
        }
        return neg == pos ? pos : -1;
    }
}
