package leetcode.a2000;

/**
 * 数组的三角和
 * {math}
 */
public class _2221Solution {

    public int triangularSum(int[] nums) {

        int n = nums.length;

        while (n > 1) {

            int[] nums1 = new int[n - 1];
            for (int i = 0; i < nums.length - 1; i++) {
                nums1[i] = (nums[i] + nums[i + 1]) % 10;
            }
            nums = nums1;
            n--;
        }
        return nums[0];
    }

    /**
     * 直接在数组原址上修改，避免额外空间开销
     * @param nums
     * @return
     */
    public int triangularSum1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }
}
