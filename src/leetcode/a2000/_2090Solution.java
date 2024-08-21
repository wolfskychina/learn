package leetcode.a2000;

import java.util.Arrays;

/**
 * 半径为k的子数组的平均值
 * {sliding window}
 */
public class _2090Solution {

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        int[] avg = new int[n];
        Arrays.fill(avg, -1);

        if (n < 2 * k + 1)
            return avg;

        int mid = k;
        int left = 0, right = 0;
        long sum = 0L; // 防止溢出

        while (right < n) {
            // 向右扩大窗口
            sum += nums[right];

            if (right - left + 1 == 2 * k + 1) {
                avg[mid] = (int) (sum / (2 * k + 1));

                mid += 1;
                sum -= nums[left];
                left++;
            }

            right++;
        }

        return avg;
    }
}
