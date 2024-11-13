package leetcode.a3000;

/**
 * 将数组划分成若干子数组
 * 每个子数组内部元素按照 加减加减。。的顺序累加和
 * 求能够得到的最大分数
 * {dp}
 */
public class _3196Solution {

    public long maximumTotalCost(int[] nums) {

        long cost[] = new long[2];
        cost[0] = nums[0];
        cost[1] = Long.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {

            long new0 = Math.max(cost[1], cost[0]) + nums[i];
            long new1 = cost[0] - nums[i];
            cost[0] = new0;
            cost[1] = new1;
        }
        return Math.max(cost[0], cost[1]);
    }
}
