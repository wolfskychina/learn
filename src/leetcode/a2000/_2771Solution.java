package leetcode.a2000;

/**
 * 从nums1和nums2的相同位置上任选1个数组成新的数组中的最长非递减子数组的长度
 * {dp}
 */
public class _2771Solution {

    /**
     * dp[x][0/1]为第x个位置上选nums1中元素或者nums2元素所能获得的最长非递减子数组的长度
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {

        int nums3[][] = new int[nums1.length][2];
        int max = 1;
        nums3[0][0] = 1;
        nums3[0][1] = 1;
        for (int i = 1; i < nums1.length; i++) {

            if (nums1[i] >= nums1[i - 1]) {
                nums3[i][0] = nums3[i - 1][0] + 1;
            }
            if (nums1[i] >= nums2[i - 1]) {
                nums3[i][0] = Math.max(nums3[i][0], nums3[i - 1][1] + 1);
            }
            if (nums1[i] < nums1[i - 1] && nums1[i] < nums2[i - 1]) {
                nums3[i][0] = 1;
            }

            if (nums2[i] >= nums1[i - 1]) {
                nums3[i][1] = nums3[i - 1][0] + 1;
            }
            if (nums2[i] >= nums2[i - 1]) {
                nums3[i][1] = Math.max(nums3[i][1], nums3[i - 1][1] + 1);
            }

            if (nums2[i] < nums1[i - 1] && nums2[i] < nums2[i - 1]) {
                nums3[i][1] = 1;
            }
            max = Math.max(max, Math.max(nums3[i][0], nums3[i][1]));
        }

        return max;
    }
}
