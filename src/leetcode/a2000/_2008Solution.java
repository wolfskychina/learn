package leetcode.a2000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出租车的最大盈利
 * {dp}类似2830题
 */
public class _2008Solution {

    public long maxTaxiEarnings(int n, int[][] rides) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int ride[] : rides) {

            List<int[]> list = map.getOrDefault(ride[1], new ArrayList<>());
            list.add(new int[] { ride[0], -ride[0] + ride[1] + ride[2] });
            map.put(ride[1], list);
        }

        long cost[] = new long[n + 1];
        for (int i = 1; i < cost.length; i++) {
            cost[i] = cost[i - 1];
            if (map.get(i) == null)
                continue;
            for (int[] arr : map.get(i)) {
                cost[i] = Math.max(cost[i], cost[arr[0]] + arr[1]);
            }
        }

        return cost[n];

    }
}
