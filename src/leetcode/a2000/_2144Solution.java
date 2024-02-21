package leetcode.a2000;

import java.util.Arrays;
/**
 * 三赠一的优惠条件下购买所有糖果所需要的最小花费
 * {easy}
 */
public class _2144Solution {

    public int minimumCost(int[] cost) {

        Arrays.sort(cost);
        int i = cost.length - 1;
        int sum = 0;
        while (i - 1 >= 0) {

            sum += cost[i] + cost[i - 1];
            i -= 3;
        }

        if (i == 0)
            sum += cost[i];

        return sum;

    }
}
