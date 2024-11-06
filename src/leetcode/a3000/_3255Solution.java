package leetcode.a3000;

import java.util.Arrays;

/**
 * 同3254
 */
public class _3255Solution {

    public int[] resultsArray(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Arrays.fill(ans, -1);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt = i == 0 || nums[i] == nums[i - 1] + 1 ? cnt + 1 : 1;
            if (cnt >= k) {
                ans[i - k + 1] = nums[i];
            }
        }
        return ans;
    }
}
