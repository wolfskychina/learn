package leetcode.a1700;

/**
 * 任意子数组和的绝对值的最大值
 */
public class _1749Solution {

    /**
     * {subarray},{dp}
     * 对于最大值，如果区间和变为小于0，那么这个区间可以直接跳过
     * 
     * @param nums
     * @return
     */
    public int maxAbsoluteSum(int[] nums) {
        int ans = 0, fMax = 0, fMin = 0;
        for (int x : nums) {
            fMax = Math.max(fMax, 0) + x;
            fMin = Math.min(fMin, 0) + x;
            ans = Math.max(ans, Math.max(fMax, -fMin));
        }
        return ans;
    }

    /**
     * {prefix sum}直接使用前缀和更加直接
     * 
     * @param nums
     * @return
     */
    public int maxAbsoluteSum1(int[] nums) {
        int s = 0, mx = 0, mn = 0;
        for (int x : nums) {
            s += x;
            // mx = Math.max(mx, s);
            // mn = Math.min(mn, s);
            if (s > mx)
                mx = s;
            else if (s < mn)
                mn = s; // 效率更高的写法
        }
        // 最大区间等于最大前缀和最小前缀的差，或者绝对值
        return mx - mn;

    }
}
