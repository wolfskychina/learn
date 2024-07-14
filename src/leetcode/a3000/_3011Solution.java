package leetcode.a3000;

/**
 * 一个下标从 0 开始且全是 正整数的数组 nums 。
 * 一次 操作 中，如果两个相邻元素在二进制下数位为 1 的数目相同 ，
 * 那么你可以将这两个元素交换。你可以执行这个操作 任意次 （也可以 0 次）。
 * 如果你可以使数组变有序，请你返回 true ，否则返回 false 。
 */
public class _3011Solution {

    /**
     * {bit manuplation},{sorting}
     * @param nums
     * @return
     */
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int preMax = 0;
        for (int i = 0; i < n;) {
            int mx = 0;
            int ones = Integer.bitCount(nums[i]);
            while (i < n && Integer.bitCount(nums[i]) == ones) {
                if (nums[i] < preMax) { // 无法排成有序的
                    return false;
                }
                mx = Math.max(mx, nums[i++]); // 更新本组最大值
            }
            preMax = mx;
        }
        return true;
    }
}
