package leetcode.a900;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import leetcode.util.TreeNode;

/**
 * 二叉树的竖直顺序的遍历
 * {binary tree},{dfs}
 */
public class _987Solution {

    private class Pair<T, K> {
        T key;
        K value;

        public Pair(T key, K value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return this.key;
        }

        public K getValue() {
            return this.value;
        }
    }

    // 不用Pair,直接用int[2]更快
    Map<Integer, Queue<Pair<Integer, Integer>>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (Queue<Pair<Integer, Integer>> q : map.values()) {
            List<Integer> tmp = new ArrayList<>();
            while (!q.isEmpty()) {
                tmp.add(q.poll().getValue());
            }
            res.add(tmp);
        }
        return res;
    }

    private void dfs(TreeNode root, int col, int dept) {

        if (root == null)
            return;

        Queue<Pair<Integer, Integer>> q = map.getOrDefault(col, new PriorityQueue<Pair<Integer, Integer>>(
                (a, b) -> a.getKey().equals(b.getKey()) ? a.getValue() - b.getValue() : a.getKey() - b.getKey()));

        q.offer(new Pair(dept, root.val));
        map.put(col, q);

        if (root.left != null)
            dfs(root.left, col - 1, dept + 1);
        if (root.right != null)
            dfs(root.right, col + 1, dept + 1);
    }
}
