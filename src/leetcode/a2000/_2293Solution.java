package leetcode.a2000;
/**
 * 极大极小游戏
 */
public class _2293Solution {
   
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        while (n != 1) {
            int m = n / 2;
            for (int i = 0; i < m; i++) {
                if (i % 2 == 0) {
                    nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            n = m;
        }
        return nums[0];
    }
}
