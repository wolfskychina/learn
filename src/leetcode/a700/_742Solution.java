package leetcode.a700;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import leetcode.util.TreeNode;

/**
 * 返回离二叉树中某个节点最近的叶子节点
 */
public class _742Solution {

    /**
     * 将二叉树转化为普通无向树，然后采用bfs的方式获取到最近的叶子结点
     * {binary tree},{graph}
     * 
     * @param root
     * @param k
     * @return
     */
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        dfs(graph, root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();

        for (TreeNode node : graph.keySet()) {
            if (node != null && node.val == k) {
                queue.add(node);
                seen.add(node);
                break;
            }
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                // 叶节点的相邻节点只有一个
                if (graph.get(node).size() == 1)
                    return node.val;
                for (TreeNode nei : graph.get(node)) {
                    if (!seen.contains(nei)) {
                        seen.add(nei);
                        queue.add(nei);
                    }
                }
            }
        }
        return 0;
    }

    // 二叉树转换成普通树的方式很巧妙 TODO
    public void dfs(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {
        // java的HashMap允许null作为key和value
        if (node != null) {
            if (!graph.containsKey(node))
                graph.put(node, new LinkedList<TreeNode>());
            if (!graph.containsKey(parent))
                graph.put(parent, new LinkedList<TreeNode>());
            graph.get(node).add(parent);
            graph.get(parent).add(node);
            dfs(graph, node.left, node);
            dfs(graph, node.right, node);
        }
    }

    int min = Integer.MAX_VALUE;

    /**
     * 尝试递归求解，太复杂了，代码有问题
     * @param root
     * @param k
     * @return
     */
    public int findClosestLeaf1(TreeNode root, int k) {

        traverse(root, k);
        return min;
    }

    private int traverse(TreeNode p, int tar) {

        if (p.val == tar) {
            if (p.left == null && p.right == null) {
                min = 0;
            } else {

                if (p.left != null) {
                    traversedown(p.left, 1);
                }
                if (p.right != null) {
                    traversedown(p.right, 1);
                }
            }

            return 0;
        }

        int l = -1;
        int r = -1;
        if (p.left != null) {
            l = traverse(p.left, tar);
            if (l >= 0 && p.right != null)
                traversedown(p.right, l + 1);
        }
        if (p.right != null) {
            r = traverse(p.right, tar);
            if (r >= 0 && p.left != null)
                traversedown(p.left, r + 1);
        }

        if (l == -1)
            return r + 1;
        return l + 1;
    }

    private void traversedown(TreeNode p, int dept) {

        if (p.left == null && p.right == null) {
            min = Math.min(min, dept);
            return;
        } else {
            if (p.left != null)
                traversedown(p.left, dept + 1);
            if (p.right != null)
                traversedown(p.right, dept + 1);
        }
    }
}
