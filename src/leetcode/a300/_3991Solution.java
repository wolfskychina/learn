package leetcode.a300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _3991Solution {

    /**
     * 转换成图的深度优先搜索
     * 
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        Map<String, List<Edge>> graph = new HashMap<>();
        Set<String> vset = new HashSet<>();
        for (int i = 0; i < equations.size(); i++) {

            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            vset.add(from);
            vset.add(to);

            if (!from.equals(to)) {
                List<Edge> list = graph.getOrDefault(from, new LinkedList<Edge>());
                list.add(new Edge(to, values[i]));
                graph.put(from, list);
                List<Edge> list2 = graph.getOrDefault(to, new LinkedList<Edge>());
                list2.add(new Edge(from, 1 / values[i]));
                graph.put(to, list2);

            }
        }

        List<Double> ans = new LinkedList<>();
        for (List<String> q : queries) {

            if (!vset.contains(q.get(0)) ||
                    !vset.contains(q.get(1))) {
                ans.add(-1.0);
                continue;
            }
            if (q.get(0).equals(q.get(1))) {
                ans.add(1.0);
                continue;
            }

            boolean found = false;
            String target = q.get(1);
            List<Edge> tmpList = new LinkedList<>();
            List<Edge> resList = new LinkedList<>();
            Set<String> tmpSet = new HashSet<>();
            tmpSet.add(q.get(0));
            for (Edge d : graph.get(q.get(0))) {
                tmpList.add(d);
                found = dfs(tmpList, tmpSet, target, graph, resList);
                if (found) {
                    break;
                }
                tmpList.remove(tmpList.size() - 1);

            }
            if (found) {
                // calcute
                double f = 1.0;
                for (Edge e : resList) {
                    f *= e.val;
                }
                ans.add(f);

            } else {
                ans.add(-1.0);

            }

        }

        double[] resd = new double[ans.size()];
        for (int i = 0; i < resd.length; i++) {
            resd[i] = ans.get(i);
        }
        return resd;

    }

    private boolean dfs(List<Edge> tmpList, Set<String> tmpSet, String target, Map<String, List<Edge>> graph,
            List<Edge> resList) {

        Edge cur = tmpList.get(tmpList.size() - 1);
        if (tmpSet.contains(cur.v)) {
            return false;
        }
        if (cur.v.equals(target)) {
            // found
            // 错误写法，java值传递无法更改原来对象的指向
            // resList = new LinkedList<>(tmpList);
            for (Edge e : tmpList) {
                resList.add(e);
            }
            return true;
        }
        boolean found = false;
        tmpSet.add(cur.v);
        for (Edge d : graph.get(cur.v)) {
            tmpList.add(d);
            found = dfs(tmpList, tmpSet, target, graph, resList);
            if (found) {
                break;
            }
            tmpList.remove(tmpList.size() - 1);

        }
        tmpSet.remove(cur.v);
        if (found) {
            return true;
        } else {
            return false;
        }
    }

    private class Edge {
        String v;
        double val;

        public Edge(String v, double val) {
            this.v = v;
            this.val = val;
        }
    }

    /**
     * union-find算法更快
     */
    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsize = equations.size();
        UnionFind unionFind = new UnionFind(2 * equationsize);
        Map<String, Integer> hashmap = new HashMap<>();
        int id = 0;
        for (int i = 0; i < equationsize; i++) {
            List<String> eq = equations.get(i);
            String var1 = eq.get(0);
            String var2 = eq.get(1);
            if (!hashmap.containsKey(var1)) {
                hashmap.put(var1, id);
                id++;
            }
            if (!hashmap.containsKey(var2)) {
                hashmap.put(var2, id);
                id++;
            }
            unionFind.union(hashmap.get(var1), hashmap.get(var2), values[i]);
        }
        int queriesize = queries.size();
        double[] res = new double[queriesize];
        for (int i = 0; i < queriesize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            Integer id1 = hashmap.get(var1);
            Integer id2 = hashmap.get(var2);
            if (id1 == null || id2 == null)
                res[i] = -1.0d;
            else {
                res[i] = unionFind.isConnected(id1, id2);
            }

        }
        return res;

    }

    private class UnionFind {
        public int[] parent;
        public double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }

        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return weight[x] / weight[y];
            else
                return -1.0d;
        }
    }

    public static void main(String[] args) {
        _3991Solution so = new _3991Solution();
        List<List<String>> equations = new LinkedList<>();
        String[][] str = { { "a", "b" }, { "c", "b" }, { "d", "b" }, { "w", "x" }, { "y", "x" }, { "z", "x" },
                { "w", "d" } };
        for (int i = 0; i < str.length; i++) {
            List<String> equ = new LinkedList<>();
            equ.add(str[i][0]);
            equ.add(str[i][1]);
            equations.add(equ);
        }

        double[] array = { 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0 };

        List<List<String>> queries = new LinkedList<>();
        String[][] qstr = { { "a", "c" }, { "b", "c" }, { "a", "e" }, { "a", "a" }, { "x", "x" }, { "a", "z" } };
        for (int i = 0; i < qstr.length; i++) {
            List<String> q1 = new LinkedList<>();
            q1.add(qstr[i][0]);
            q1.add(qstr[i][1]);
            queries.add(q1);
        }

        so.calcEquation(equations, array, queries);
    }

}
