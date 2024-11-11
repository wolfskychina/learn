package leetcode.a2000;

/**
 * 一个小组能够选出的最大实力元素的组
 * 实力是指选出的组合种所有元素的乘积
 * {dp}
 */
public class _2708Solution {

    /**
     * 注意初始值
     * @param nums
     * @return
     */
    public long maxStrength(int[] nums) {

        long min = nums[0];
        long max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long p1 = min * nums[i];
            long p2 = max * nums[i];
            // 比较的时候要把从当前元素nums[i]重新开始的情况也算上
            // 开始的时候落了这种可能
            min = Math.min(Math.min(min, nums[i]), Math.min(p1, p2));
            max = Math.max(Math.max(max, nums[i]), Math.max(p1, p2));
        }
        return max;
    }
}
