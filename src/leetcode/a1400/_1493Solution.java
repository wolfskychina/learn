package leetcode.a1400;

/**
 * 删掉一个元素后全部为1的最长子数组
 * 即使子数组中全部元素都是1也必须删除一个元素
 */
public class _1493Solution {

    /**
     * {two pointers}
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {

        int l = 0;
        int r = 0;
        int res = 0;
        int none1 = 0;
        while (r < nums.length) {

            if (nums[r] != 1)
                none1++;
            if (none1 <= 1) {
                res = Math.max(res, r - l);
            }
            r++;

            while (none1 > 1 && l < r) {
                if (nums[l] != 1) {
                    none1--;
                }
                l++;
            }
        }

        return res;
    }
}
