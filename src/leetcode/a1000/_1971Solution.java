package leetcode.a1000;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 寻找图中是否有从起点到终点的路径
 * {graph}
 */
public class _1971Solution {

    /**
     * {bfs} 邻接表 速度比较慢
     * 
     * @param n
     * @param edges
     * @param source
     * @param destination
     * @return
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (source == destination)
            return true;
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        q.offer(source);
        set.add(source);
        Map<Integer, List<Integer>> edge = new HashMap<>();

        for (int[] e : edges) {
            List<Integer> list1 = edge.getOrDefault(e[0], new ArrayList<Integer>());
            list1.add(e[1]);
            edge.put(e[0], list1);
            List<Integer> list2 = edge.getOrDefault(e[1], new ArrayList<>());
            list2.add(e[0]);
            edge.put(e[1], list2);

        }

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {

                int v = q.poll();
                if (edge.get(v) == null)
                    continue;
                for (int newv : edge.get(v)) {
                    if (set.contains(newv)) {
                        continue;
                    }
                    if (newv == destination)
                        return true;
                    q.offer(newv);
                    set.add(newv);
                }
            }
        }
        return false;

    }

    /**
     * 只考虑点的遍历，速度快很多
     * 
     * @param n
     * @param edges
     * @param source
     * @param destination
     * @return
     */
    public boolean validPath1(int n, int[][] edges, int source, int destination) {
        boolean flag = true;
        boolean[] visited = new boolean[n];
        visited[source] = true;
        while (flag) {
            flag = false;
            for (int[] i : edges) {
                if (visited[i[0]] != visited[i[1]]) {
                    visited[i[0]] = true;
                    visited[i[1]] = true;
                    flag = true;
                }
            }
            if (visited[destination])
                return true;
        }
        return false;
    }

    /**
     * {union find}速度最快
     * @param n
     * @param edges
     * @param source
     * @param destination
     * @return
     */
    public boolean validPath2(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.uni(edge[0], edge[1]);
        }
        return uf.connect(source, destination);
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;
    
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
    
        public void uni(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx]++;
                }
            }
        }
   
        /**
         * 这种find方法不能在查找时压缩层次
         * 是只读的查找
         * @param x
         * @return
         */
        public int find(int x) {
            if (parent[x] != x) {
                x = find(parent[x]);
            }
            return x;
        }
    
        public boolean connect(int x, int y) {
            return find(x) == find(y);
        }
    }
    
}

