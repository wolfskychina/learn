package leetcode.a400;

/**
 * 统计数组中连续的1，但是允许最多将其中一个0变成1
 */
public class _487Solution {

    public int findMaxConsecutiveOnes(int[] nums) {

        int i = 0;
        int res = 0;
        int count = 0;
        while (i < nums.length) {

            while (i < nums.length && nums[i] == 1) {
                count++;
                i++;
            }
            if (i == nums.length) {
                res = Math.max(res, count);
                break;
            }
            // count first 0;
            int idx0 = i;
            // flip first 0;
            count++;
            i++;
            while (i < nums.length && nums[i] == 1) {
                i++;
                count++;
            }
            res = Math.max(res, count);

            if (i == nums.length)
                break;

            // cancle the last flip of 0
            count = i - idx0 - 1;
        }

        return res;
    }
}
