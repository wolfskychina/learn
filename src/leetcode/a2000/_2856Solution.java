package leetcode.a2000;

import java.util.List;

/**
 * 已排好序的非减有序列表
 * 每次可以删除大小不相同的两个元素
 * 最后能够剩余的最少元素数量
 * {greedy},{binary search}
 * 两两抵消问题
 */
public class _2856Solution {

    /**
     * 假设 x 出现次数最多，其出现次数为 maxCnt。
     * 
     * 分类讨论：
     * 
     * 如果 maxCnt⋅2>n，其余所有 n−maxCnt 个数都要与 x 消除，所以最后剩下 maxCnt⋅2−n 个数。
     * 如果 maxCnt⋅2≤n 且 n 是偶数，那么可以把其余数消除至剩下 maxCnt 个数，然后再和 x 消除，最后剩下 0 个数。
     * 如果 maxCnt⋅2≤n 且 n 是奇数，同上，最后剩下 1 个数。
     * 
     * 
     * @param nums
     * @return
     */
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();
        int x = nums.get(n / 2);
        int maxCnt = lowerBound(nums, x + 1) - lowerBound(nums, x);
        return Math.max(maxCnt * 2 - n, n % 2);
    }

    // 开区间写法
    private int lowerBound(List<Integer> nums, int target) {
        int left = -1, right = nums.size(); // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums.get(mid) < target) {
                left = mid; // 范围缩小到 (mid, right)
            } else {
                right = mid; // 范围缩小到 (left, mid)
            }
        }
        return right; // 或者 left+1
    }
}
