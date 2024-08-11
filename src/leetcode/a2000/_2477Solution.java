package leetcode.a2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 各地议员到首都开会，所需要消耗的最少汽油
 */
public class _2477Solution {

    /**
     * {dfs}
     * roads满足一颗最小连通树
     * 转换为经过每一条边所需要的最少车的数量来计算
     * 递归计算
     * 
     * @param roads
     * @param seats
     * @return
     */
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : roads) {
            int x = e[0], y = e[1];
            g[x].add(y); // 记录每个点的邻居
            g[y].add(x);
        }

        dfs(0, -1, g, seats);
        return ans;
    }

    private long ans;

    private int dfs(int x, int fa, List<Integer>[] g, int seats) {
        int size = 1;
        for (int y : g[x]) {
            if (y != fa) { // 递归子节点，不能递归父节点
                size += dfs(y, x, g, seats); // 统计子树大小
            }
        }
        if (x > 0) { // x 不是根节点
            ans += (size - 1) / seats + 1; // ceil(size/seats)
        }
        return size;
    }
}
