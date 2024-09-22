package leetcode.a2000;

/**
 * 将区间内数字按位与所能得到数字最大的最长子数组
 */
public class _2419Solution {

    /**
     * 一定是全部都是最大值的最长子数组
     * {two pointers}
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {

        int max = 0;
        for (int i = 0; i < nums.length; i++) {

            max = Math.max(max, nums[i]);

        }

        int res = 0;

        int i = 0;

        while (i < nums.length) {

            while (i < nums.length && nums[i] != max) {
                i++;
            }
            if (i == nums.length)
                break;
            int l = i;
            i++;

            while (i < nums.length && nums[i] == nums[i - 1]) {

                i++;
            }
            res = Math.max(res, i - l);

        }

        return res;

    }

    public static void main(String[] args) {

        _2419Solution so = new _2419Solution();
        int[] nums = { 1, 2, 3, 3, 2, 2 };
        so.longestSubarray(nums);
    }
}
