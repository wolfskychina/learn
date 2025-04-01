package leetcode.a2000;

import java.util.HashMap;
import java.util.Map;

/**
 * 最大的线性股票得分
 * 等式移项找规律
 * {math},{hashmap}
 */
public class _2898Solution {
   
    public long maxScore(int[] prices) {
        long maxSum = 0;
        Map<Integer, Long> sums = new HashMap<Integer, Long>();
        // 题目要求满足的 prices[indexes[j]] - prices[indexes[j - 1]] == indexes[j] - indexes[j - 1] 直接移项
        // 变成 prices[indexes[j]] - indexes[j]  == prices[indexes[j - 1]] - indexes[j - 1]
        // 特征值只跟当前坐标和值有关
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            int diff = prices[i] - i;
            long sum = sums.getOrDefault(diff, 0L) + prices[i];
            sums.put(diff, sum);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
