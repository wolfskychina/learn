package leetcode.a1000;

/**
 * 一排景点中的最佳观光组合
 * The score of a pair (i < j) of sightseeing spots
 *  is values[i] + values[j] + i - j
 * {dp},{greedy}
 */
public class _1014Solution {

    /**
     * 将计算公式 values[i] + values[j] + i - j拆成两部分
     * 遍历j的时候，values[j] - j是固定不变的
     * values[i] + i 是小于j的所有元素中的最大值，可以通过
     * 之前的遍历记录
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, mx = values[0] + 0;
        for (int j = 1; j < values.length; ++j) {
            ans = Math.max(ans, mx + values[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, values[j] + j);
        }
        return ans;
    }
}
