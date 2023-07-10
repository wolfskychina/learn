package leetcode.array;

import java.util.Arrays;

/**
 * 小朋友分糖果，每个人有一个权重
 * 每个人糖果数量符合左右人的相对权重大小
 * 求最少需要多少糖果
 */
public class _135Solution {
  // 符合贪心规则 
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = candies[ratings.length - 1];
        // 从右往左扫描的时候，就要既满足和右侧大小的规则，也要满足和左侧大小的规则。
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // 取最大值是为了同时满足和左侧与右侧的规则要求。
                // candies[i]至少能够满足和左侧的规则
                // candies[i + 1] + 1至少能够满足和右侧的规则
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }
}
