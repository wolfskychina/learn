package leetcode.a3000;

/**
 * 新增道路查询后的最短距离
 * 和3243不同的是，这次新增的后续查询和之前的查询不会有重叠区间
 * 但是可以是包含关系
 */
public class _3244Solution {

    class UnionFind {
        public final int[] fa;

        public UnionFind(int size) {
            fa = new int[size];
            for (int i = 1; i < size; i++) {
                fa[i] = i;
            }
        }

        public int find(int x) {
            if (fa[x] != x) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }
    }

    /**
     * 有了条件限制
     * 并查集，但是合并的是边（给边进行编号）
     * @param n
     * @param queries
     * @return
     */
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        UnionFind uf = new UnionFind(n - 1);
        int[] ans = new int[queries.length];
        int cnt = n - 1; // 并查集连通块个数
        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1] - 1;
            int fr = uf.find(r);
            for (int i = uf.find(l); i < r; i = uf.find(i + 1)) {
                // 每执行一遍循环就是发现了在[l,r-1]区间内可以合并的一个线段
                uf.fa[i] = fr;
                cnt--;
            }
            ans[qi] = cnt;
        }
        return ans;
    }

}
