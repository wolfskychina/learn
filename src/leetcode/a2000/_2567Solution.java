package leetcode.a2000;

import java.util.Arrays;

/**
 * 修改数组中的两个元素大小所能得到的最小得分
 * The low score of nums is the minimum absolute difference between any two
 * integers.
 * The high score of nums is the maximum absolute difference between any two
 * integers.
 * The score of nums is the sum of the high and low scores.
 * Return the minimum score after changing two elements of nums.
 * {greedy}
 */
public class _2567Solution {

    /**
     * 只要有重复数字，最小得分的最小值就可以是0
     * 而最大得分的最小值只跟两端的数字相关
     * 减小最大得分可以有以下三种操作
     * 
     * 修改最大的两个数为 nums[n−3]，最大得分为 nums[n−3]−nums[0]；
     * 修改最小的为 nums[1]，最大的为 nums[n−2]，最大得分为 nums[n−2]−nums[1]；
     * 修改最小的两个数为 nums[2]，最大得分为 nums[n−1]−nums[2]。
     * 
     * @param a
     * @return
     */
    public int minimizeSum(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        return Math.min(Math.min(a[n - 3] - a[0], a[n - 2] - a[1]), a[n - 1] - a[2]);
    }

    /**
     * 一趟扫描免排队，核心是找最小的三个值和最大的三个值
     * 
     * @param nums
     * @return
     */
    public int minimizeSum1(int[] nums) {
        if (nums.length == 3) {
            return 0;
        }
        int a1, a2, a3, b1, b2, b3;
        // max a1 > a2 > a3
        a1 = a2 = a3 = 0;
        // min b1 < b2 < b3
        b1 = b2 = b3 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n < b3) {
                if (n < b2) {
                    if (n < b1) {
                        b3 = b2;
                        b2 = b1;
                        b1 = n;
                    } else {
                        b3 = b2;
                        b2 = n;
                    }
                } else {
                    b3 = n;
                }
            }
            if (n > a3) {
                if (n > a2) {
                    if (n > a1) {
                        a3 = a2;
                        a2 = a1;
                        a1 = n;
                    } else {
                        a3 = a2;
                        a2 = n;
                    }
                } else {
                    a3 = n;
                }
            }
        }
        return Math.min(a1 - b3, Math.min(a3 - b1, a2 - b2));
    }
}
