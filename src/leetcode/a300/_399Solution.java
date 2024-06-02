package leetcode.a300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 已知一些数相除的结果，给出一些新的数对，能否获得这些数对的除数
 * {graph}
 * 
 */
public class _399Solution {

    public double[] calcEquation(List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        // 构造邻接列表
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

    public static void main(String[] args) {

        _399Solution so = new _399Solution();
        List<List<String>> equ = new LinkedList<List<String>>();
        List<String> list1 = new LinkedList<String>();
        list1.add("a");
        list1.add("b");
        List<String> list2 = new LinkedList<String>();
        list2.add("b");
        list2.add("c");
        equ.add(list1);
        equ.add(list2);

        double[] values = { 2.0, 3.0 };
        List<List<String>> query = new LinkedList<List<String>>();
        List<String> q1 = new LinkedList<String>();
        q1.add("a");
        q1.add("c");
        query.add(q1);
        so.calcEquation(equ, values, query);
    }
}
