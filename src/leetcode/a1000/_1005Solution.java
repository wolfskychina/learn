package leetcode.a1000;

import java.util.Arrays;

public class _1005Solution {

    public int largestSumAfterKNegations(int[] nums, int k) {

        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length && nums[i] < 0 && k != 0) {
            nums[i] = -nums[i];
            i++;
            k--;
        }
        if (k != 0) {
            if ((i == nums.length || nums[i] != 0) && k % 2 == 1) {
                Arrays.sort(nums);
                nums[0] = -nums[0];
            }
        }

        int sum = 0;
        for (int j : nums) {
            sum += j;
        }

        return sum;
    }
}
