package leetcode.lcp;

import java.util.Arrays;

/**
 * 从nums数组中任选两个，和小于target的方案数
 */
public class Lcp28 {

    /**
     * 排序加双指针 31ms
     * {two pointers}
     */
    public int purchasePlans1(int[] nums, int target) {
        int left, right;
        long n = 0;
        Arrays.sort(nums);
        for (left = 0, right = nums.length - 1; left < right;) {
            if (nums[left] + nums[right] > target)
                right--;
            else {
                n = n + right - left;
                left++;
            }
        }
        return (int) (n % 1000000007);
    }

    /**
     * hash表，9ms
     */
    public int purchasePlans(int[] nums, int target) {
        // 哈希表
        int[] rec = new int[target];
        for (int num : nums) {
            if (num < target) {
                rec[num]++;
            }
        }

        for (int i = 1; i < target; i++) {
            rec[i] += rec[i - 1];
        }

        long ans = 0;
        for (int i = 1, half = target >> 1; i <= half; i++) {
            long curCntSum = rec[i], curCntNum = curCntSum - rec[i - 1];
            if (curCntNum == 0) {
                continue;
            }
            ans += curCntNum * (rec[target - i] - curCntSum);
            ans += curCntNum * (curCntNum - 1) >> 1;
        }
        return (int) (ans % 1000000007);
    }
}
