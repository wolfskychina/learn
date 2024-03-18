package leetcode.a2000;
/**
 * 元素和最小的山形三元组
 * {easy}
 */
public class _2908Solution {

    public int minimumSum(int[] nums) {

        if (nums.length < 3) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    if (nums[j] > nums[i] && nums[j] > nums[k]) {
                        min = Math.min(min, nums[i] + nums[j] + nums[k]);
                        found = true;
                    }
                }
            }

        }

        if (found)
            return min;
        else
            return -1;
    }
}
