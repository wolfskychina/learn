package leetcode.a2000;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 从给定原材料中找到所有能够做出的菜
 * 菜本身也可能是其他菜的中间原料，而且可能互相依赖形成环
 * 使用拓扑排序，环里面的菜不会入队列
 * {graph},{topological sorting}
 */
public class _2115Solution {

    /**
     * 入队列的时候判断一下是否是菜
     * @param recipes
     * @param ingredients
     * @param supplies
     * @return
     */
    public List<String> findAllRecipes(
            String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Set<String> reSet = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (String r : recipes) {
            reSet.add(r);
        }

        Map<String, List<String>> nei = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {

            String val = recipes[i];
            for (String key : ingredients.get(i)) {

                List<String> list = nei.getOrDefault(key, new ArrayList<>());
                list.add(val);
                nei.put(key, list);
                indegree.put(val, indegree.getOrDefault(val, 0) + 1);
            }
        }

        Queue<String> q = new ArrayDeque<>();

        for (String start : supplies) {
            if (indegree.get(start) == null) {
                q.offer(start);
                if (reSet.contains(start))
                    res.add(start);
            }
        }

        while (!q.isEmpty()) {
            String cur = q.poll();
            // 因为把原材料都入队列了
            // 所以可能出现邻接表不存在的情况
            // 无法通向其他任何节点
            if (nei.get(cur) == null)
                continue;
            for (String next : nei.get(cur)) {

                int count = indegree.get(next);
                if (count == 1) {
                    indegree.remove(next);
                    q.offer(next);
                    // 这个地方不判断是否是菜也可以
                    // 因为只要不是第一步入列的一定是加工出来的菜
                    // 原始材料无法通过邻接关系加工出来
                    // if (reSet.contains(next))
                        res.add(next);
                } else {
                    indegree.put(next, count - 1);
                }
            }
        }

        return res;

    }
}
