package leetcode.a2000;

/**
 * 访问数组中的位置使得分数最大
 * 从左往右遍历数组中的数字，每个数字可以选或者不选
 * 如果选当前数字和上一个选的数字奇偶性相同，那么得到该数字分数
 * 如果奇偶性相反，那么得到该数字分数之后还要减去x值
 * 问最大能得到的分数多少
 */
public class _2786Solution {

    /**
     * {dp}
     * 
     * @param nums
     * @param x
     * @return
     */
    public long maxScore(int[] nums, int x) {

        long s[] = new long[2];
        s[nums[0] % 2] = nums[0];
        // TODO 初始化值最关键,避免不存在的初始化分数被选中
        // 因为存在-x的可能，有可能s[0/1]出现负数
        // 所以s[]不能初始为0，而应该是比较小的值
        // 但是也不能为Long.MIN_VALUE，-x可能溢出
        s[(nums[0] + 1) % 2] = Integer.MIN_VALUE;
        long max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                s[0] = Math.max(s[0], s[1] - x) + nums[i];
            } else {
                s[1] = Math.max(s[1], s[0] - x) + nums[i];
            }
            max = Math.max(max, s[nums[i] % 2]);
        }

        return max;
    }
}
