package leetcode.a2000;

import java.util.Arrays;

/**
 * 打家劫舍
 * 限制条件，不能偷相邻的房子
 * 至少要偷k个房子
 * 求，满足条件的所有偷法中，每种偷法中偷到的钱最多的房子中，所有钱最多的房子中
 * 最小值可能是多少
 * {TODO}
 */
public class _2560Solution {

    /**
     * {binary search},{greedy}
     * 记 f(y) 为在最大金额 y 的限制下，小偷可以偷取的最大房屋数目
     * 关键在于f(y)是关于y的非递减函数
     * 通过二分法找到满足 f(y)≥k 的最小 y
     * @param nums
     * @param k
     * @return
     */
    public int minCapability(int[] nums, int k) {

        // 最大金额y的上下限
        int lower = Arrays.stream(nums).min().getAsInt();
        int upper = Arrays.stream(nums).max().getAsInt();

        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            int count = 0;
            boolean visited = false;
            for (int x : nums) {
                if (x <= middle && !visited) {
                    count++;
                    visited = true;
                } else {
                    visited = false;
                }
            }
            if (count >= k) {
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }
        return lower;
    }
}
