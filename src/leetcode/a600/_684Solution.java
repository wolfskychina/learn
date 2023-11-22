package leetcode.a600;
/**
 * 寻找无向图中的最后一个冗余边
 */
public class _684Solution {

    int[] parent;

    /**
     * {union find},{graph}
     */
    public int[] findRedundantConnection(int[][] edges) {

        // 添加边的时候判断是否是同一个集合
        // 如果是同一个集合，则是回路
        // 如果不是同一个集合，需要归并
        parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[] res = new int[2];
        for (int[] edge : edges) {

            int root0 = foundRoot(edge[0]);
            int root1 = foundRoot(edge[1]);
            if(root0==root1){
                res = edge;
            }else if (root0 == edge[0]) {
                parent[edge[0]] = edge[1];
            } else if (root1 == edge[1]) {
                parent[edge[1]] = edge[0];
            } else if (root0 != root1) {
                parent[root1] = root0;
            } 
        }

        return res;

    }

    private int foundRoot(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    public static void main(String[] args){
        _684Solution so  = new _684Solution();
        int[][] edges = {{1,2},{1,3},{2,3}};
        so.findRedundantConnection(edges);
    }
}
