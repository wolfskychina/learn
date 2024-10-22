package leetcode.a2000;

/**
 * 两个数组中所有数对的异或和
 */
public class _2425Solution {

    /**
     * {bit manipulation}
     * @param nums1
     * @param nums2
     * @return
     */
    public int xorAllNums(int[] nums1, int[] nums2) {
        int res = 0;
        int n = nums1.length;
        int m = nums2.length;
        if (n % 2 == 1) {
            for (int i = 0; i < m; i++) {
                res ^= nums2[i];
            }
        }
        if (m % 2 == 1) {
            for (int i = 0; i < n; i++) {
                res ^= nums1[i];
            }
        }
        return res;
    }
}
