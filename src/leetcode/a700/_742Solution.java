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

    /**
     * 尝试递归求解
     * 
     * @param root
     * @param k
     * @return
     */
    private int minDist = Integer.MAX_VALUE;
    private int closestLeaf = -1;

    public int findClosestLeaf1(TreeNode root, int k) {
        traverse(root, k);
        return closestLeaf;
    }

    // 返回值为 K 到当前节点 root 的距离（若无则返回 -1）
    private int traverse(TreeNode root, int k) {
        if (root == null)
            return -1;

        // 找到 K 节点，开始搜索其子树中的叶节点
        if (root.val == k) {
            searchClosestLeaf(root, 0);
            return 1; // K 到父节点的距离为1 题目的意思
        }
        int leftDist = traverse(root.left, k);
        int rightDist = traverse(root.right, k);

        if (leftDist != -1) {// K在noderoot的左子树中
            // K 在左子树中，检查右子树的叶节点（距离为 leftDist + 1）
            searchClosestLeaf(root.right, leftDist + 1);
            return leftDist + 1; // 返回 K 到当前 root 的距离
        }

        if (rightDist != -1) {
            // K 在右子树中，检查左子树的叶节点（距离为 rightDist + 1）
            searchClosestLeaf(root.left, rightDist + 1);
            return rightDist + 1;
        }
        return -1;
    }

    // 搜索当前子树中所有叶节点，更新最近距离
    private void searchClosestLeaf(TreeNode node, int dist) {
        if (node == null || dist >= minDist)
            return;

        // 找到叶节点，更新结果
        if (node.left == null && node.right == null) {
            if (dist < minDist) {
                minDist = dist;
                closestLeaf = node.val;
            }
            return;
        }

        searchClosestLeaf(node.left, dist + 1);
        searchClosestLeaf(node.right, dist + 1);
    }
}
