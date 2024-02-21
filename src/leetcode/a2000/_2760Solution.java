package leetcode.a2000;
/**
 * 最长奇偶子数组
 */
public class _2760Solution {

    /**
     * 注意迭代中的退出条件
     */
    public int longestAlternatingSubarray(int[] nums, int threshold) {

        int l = 0;
        int r = 0;
        int max = 0;

        while (r < nums.length) {

            while (r < nums.length && (nums[r] % 2 == 1 || nums[r] > threshold)) {
                r++;
            }
            if (r == nums.length)
                break;
            l = r;
            r = l + 1;
            while (r < nums.length) {
                if (nums[r] % 2 == 1 && nums[r] <= threshold) {
                    r++;
                    if (r < nums.length && nums[r] <= threshold && nums[r] % 2 == 0) {
                        r++;
                        continue;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            max = Math.max(max, r - l);
            if (r == nums.length) {
                break;
            }

        }

        return max;

    }
}
