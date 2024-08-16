package leetcode.a2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 销售利润最大化
 */
public class _2830Solution {

    /**
     * {dp}
     * 设f[n]为前n个房屋售卖的最大利润
     * 那么f[n]要么第n个房子不卖，那么就是f[n-1]
     * 要么第n个房子卖，那么就是max(f[i]+ offer(i,n))其中[i,n]是以第n个房子结尾的所有出价情况，i是出价购买
     * 的起始房屋
     * 
     * @param n
     * @param offers
     * @return
     */
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        List<int[]>[] groups = new ArrayList[n];
        Arrays.setAll(groups, e -> new ArrayList<>());
        for (var offer : offers)
            groups[offer.get(1)].add(new int[] { offer.get(0), offer.get(2) });

        var f = new int[n + 1];
        for (int end = 0; end < n; end++) {
            f[end + 1] = f[end];
            for (var p : groups[end])
                f[end + 1] = Math.max(f[end + 1], f[p[0]] + p[1]);
        }
        return f[n];
    }
}
