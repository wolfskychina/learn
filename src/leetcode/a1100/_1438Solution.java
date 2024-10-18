package leetcode.a1100;

import java.util.TreeMap;

/**
 * 区间中元素之差的绝对值不超过limit的最长子数组
 * {two pointers},{TODO}
 */
public class _1438Solution {

    /**
     * 没看懂。。。
     * 
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        // l, r 是 nums 的左右指针, len 是 nums 的长度, minL 和 minR 是最小值区间的左右指针, maxL 和 maxR
        // 是最大值区间的左右指针.
        int l = 0, r = 0, len = nums.length, minL = 0, minR = -1, maxL = len, maxR = len - 1;
        // 这个数组用来记录最小值和最大值
        int[] ascending = new int[len];
        // 开始遍历 nums
        while (r < len) {
            // 每一次遍历到的数字, 并更新子集右指针
            int n = nums[r++];
            // 如果遍历到的数字在最小值区间内, 就收缩最小值区间
            while (minR >= minL && n < ascending[minR])
                minR--;
            // 如果遍历到的数字在最大值区间内, 就收缩最大值区间
            while (maxR >= maxL && n > ascending[maxL])
                maxL++;
            // 拓展最小值和最大值区间
            ascending[++minR] = ascending[--maxL] = n;
            // 判断子集长度是否符合 limit 的要求, 如果不符合要求, 就收缩子集
            if (ascending[maxR] - ascending[minL] > limit) {
                // 开始收缩子集, 使子集左指针右移
                // 如果子集左指针是最小值, 那么最小值将被移除, 所以更新存储最小值的区间
                if (nums[l] == ascending[minL])
                    minL++;
                // 如果子集左指针是最大值, 那么最大值将被移除, 所以更新存储最大值的区间
                if (nums[l++] == ascending[maxR])
                    maxR--;
            }
        }
        // 返回结果
        return r - l;
    }

    /**
     * 比较慢的普通解法，但是比较好理解
     * {TreeMap}
     * 
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray1(int[] nums, int limit) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < nums.length) {
            m.put(nums[right], m.getOrDefault(nums[right], 0) + 1);
            while (m.lastKey() - m.firstKey() > limit) {
                m.put(nums[left], m.get(nums[left]) - 1);
                if (m.get(nums[left]) == 0) {
                    m.remove(nums[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
