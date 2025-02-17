package leetcode.a1000;

import java.util.Arrays;

/**
 * 两地调度
 * 同2611题
 * {greedy},{construction}
 */
public class _1029Solution {

    public int twoCitySchedCost(int[][] costs) {

        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            sum += costs[i][1];
        }
        int d[] = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            d[i] = costs[i][0] - costs[i][1];
        }
        Arrays.sort(d);
        for (int i = 0; i < d.length / 2; i++) {
            sum += d[i];
        }

        return sum;
    }
}
