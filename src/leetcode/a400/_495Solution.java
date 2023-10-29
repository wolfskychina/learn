package leetcode.a400;
/**
 * 总中毒时间统计
 * 中毒效果消失前重复攻击，中毒起始时间重置
 */
public class _495Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int res = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {

            if (timeSeries[i + 1] <= timeSeries[i] + duration - 1) {
                res += timeSeries[i + 1] - timeSeries[i];
            } else {
                res += duration;
            }
        }
        if (timeSeries.length != 0)
            res += duration;

        return res;

    }
}
