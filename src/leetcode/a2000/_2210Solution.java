package leetcode.a2000;

/**
 * 统计数组中峰和谷的数量
 * {easy}
 */
public class _2210Solution {

    public int countHillValley(int[] nums) {

        int l = 1, r = 1;
        int count = 0;
        while (l < nums.length - 1) {

            while (r < nums.length && nums[r] == nums[l])
                r++;
            r--;
            if (l > 0 && r + 1 < nums.length && nums[l - 1] > nums[l] && nums[r] < nums[r + 1]) {
                count++;
            }
            if (l > 0 && r + 1 < nums.length && nums[l - 1] < nums[l] && nums[r] > nums[r + 1]) {
                count++;
            }
            l = r + 1;
            r = l;
        }

        return count;

    }
}
