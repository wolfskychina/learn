package leetcode.a2000;

/**
 * 统计无向图中无法互相到达的节点对的数量
 * {graph},{union-find}
 */
public class _2316Solution {

    public long countPairs(int n, int[][] edges) {
        // union-find分堆，每堆的节点数量统计
        Union un = new Union(n);
        for (int[] e : edges) {
            un.union(e[0], e[1]);
        }

       // 总对数量-联通分量内部节点对数量即可
       long res= (long)n*(n-1)/2;
       for(int i=0;i<n;i++){
           int x = un.find(i);
           if(x==i&&un.num[x]>0)
              res -= (long)un.num[x]*(un.num[x]-1)/2;
           
       }
       return res;

    }

    private class Union {

        int parent[];
        int num[];

        public Union(int n) {
            parent = new int[n];
            num = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                num[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {

            int rx = find(x), ry = find(y);
            if (rx != ry) {
                if (num[rx] > num[ry]) {
                    parent[ry] = rx;
                    num[rx] += num[ry];
                } else {
                    parent[rx] = ry;
                    num[ry] += num[rx];
                }
            }

        }
    }
}
