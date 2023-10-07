package leetcode.a300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _399Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        List<Double> ans = new ArrayList<>();

        // key, <key,value>
        Map<String, Map<List<String>, Integer>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {

            List<String> pair = equations.get(i);
            Map<List<String>, Integer> tmp = map.getOrDefault(pair.get(0), new HashMap<List<String>, Integer>());
            tmp.put(pair, i);
            map.put(pair.get(0), tmp);

        }

        for (List<String> q : queries) {
            String target = q.get(1);

            if (!map.containsKey(q.get(0))) {
                ans.add(-1.0);
                continue;
            }

            Map<List<String>, Integer> toCheck = map.get(q.get(0));

            if (toCheck.containsKey(q)) {
                ans.add(values[toCheck.get(q)]);
                continue;
            }

            boolean found = false;
            List<List<String>> sList = new LinkedList<>();
            List<List<String>> res = new LinkedList<>();
            for (List<String> list : toCheck.keySet()) {
                // dfs start pair
                Set<String> set = new HashSet<>();
                set.add(list.get(0));
                if (dfs(set, sList, list, map, target, res)) {
                    found = true;
                    break;
                }

            }
            if (found) {
                // find a link
                // deal sList
                double f = 1;
                for (List<String> list : res) {

                    f *= values[map.get(list.get(0)).get(list)];
                }
                ans.add(f);
            } else {
                ans.add(-1.0);
            }

        }

        double[] res1 = new double[ans.size()];
        for (int i = 0; i < res1.length; i++) {
            res1[i] = ans.get(i);
        }
        return res1;
    }

    /**
     * 
     * @param set
     * @param sList
     * @param list
     * @param map
     * @param target
     * @param ans
     * @return
     */
    private boolean dfs(Set<String> set, List<List<String>> sList, List<String> list,
            Map<String, Map<List<String>, Integer>> map, String target, List<List<String>> ans) {

        // found a circle
        if (set.contains(list.get(1))) {
            return false;
        }
        // found a ans
        if (list.get(1).equals(target)) {
            sList.add(list);
            ans.addAll(sList) ;
            return true;
        }
        String start = list.get(1);
        set.add(start);
        sList.add(list);
        boolean found = false;
        if (map.get(start) != null) {

            for (List<String> nlist : map.get(start).keySet()) {

                found = dfs(set, sList, nlist, map, target, ans);
                if (found)
                    break;

            }
        }

        sList.remove(sList.size() - 1);
        set.remove(start);
        return found;

    }

    public static void main(String[] args){

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

        double[] values = {2.0,3.0};
        List<List<String>> query =new LinkedList<List<String>>();
        List<String> q1 = new LinkedList<String>();
        q1.add("a");
        q1.add("c");
        query.add(q1);
        so.calcEquation(equ, values, query);
    }
}
