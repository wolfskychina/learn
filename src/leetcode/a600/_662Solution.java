package leetcode.a600;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.util.TreeNode;

/**
 * 二叉树所有层节点的最大宽度
 * 最大宽度指两边非空节点之间（在满二叉树中）的距离（null值和不存在的节点都算）
 * {binary tree}
 */
public class _662Solution {

    /**
     * 模拟层次遍历，每次把两端的空值去掉
     * 内存超限制
     * 
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        if (root == null)
            return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {

            while (!q.isEmpty() && q.peekFirst().val == 999)
                q.pollFirst();
            while (!q.isEmpty() && q.peekLast().val == 999)
                q.pollLast();
            if (q.isEmpty())
                break;
            max = Math.max(max, q.size());

            Deque<TreeNode> qq = new ArrayDeque<>();
            int k = q.size();
            for (int i = 0; i < k; i++) {
                TreeNode n = q.poll();
                if (n.left == null) {
                    qq.offer(new TreeNode(999));
                } else {
                    qq.offer(n.left);
                }
                if (n.right == null) {
                    qq.offer(new TreeNode(999));
                } else {
                    qq.offer(n.right);
                }
            }

            q = qq;
        }

        return max;

    }

    /**
     * 实际上中间的null值不需要填充新的节点，而是靠给存在的节点标记在满二叉树中的序号，直接计算宽度
     * {bfs}
     * 
     * @param root
     * @return
     */
    private class Pair<T, J> {

        T key;
        J value;

        Pair(T key, J value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public J getValue() {
            return value;
        }
    }

    public int widthOfBinaryTree1(TreeNode root) {
        int res = 1;
        List<Pair<TreeNode, Integer>> arr = new ArrayList<Pair<TreeNode, Integer>>();
        arr.add(new Pair<TreeNode, Integer>(root, 1));
        while (!arr.isEmpty()) {
            List<Pair<TreeNode, Integer>> tmp = new ArrayList<Pair<TreeNode, Integer>>();
            for (Pair<TreeNode, Integer> pair : arr) {
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                if (node.left != null) {
                    tmp.add(new Pair<TreeNode, Integer>(node.left, index * 2));
                }
                if (node.right != null) {
                    tmp.add(new Pair<TreeNode, Integer>(node.right, index * 2 + 1));
                }
            }
            res = Math.max(res, arr.get(arr.size() - 1).getValue() - arr.get(0).getValue() + 1);
            arr = tmp;
        }
        return res;
    }

    Map<Integer, Integer> levelMin = new HashMap<Integer, Integer>();

    /**
     * 深度优先，每次同一层总是最左侧的节点被访问到
     * 保存这个节点的值，每次遍历到同层的节点就和这个节点的编号做差
     * {dfs}
     * 
     * @param root
     * @return
     */
    public int widthOfBinaryTree2(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
        // 只在第一次访问到（最左侧）的时候保存
        levelMin.putIfAbsent(depth, index); // 每一层最先访问到的节点会是最左边的节点，即每一层编号的最小值
        return Math.max(index - levelMin.get(depth) + 1,
                Math.max(dfs(node.left, depth + 1, index * 2), dfs(node.right, depth + 1, index * 2 + 1)));
    }

    public static void main(String[] args) {

        _662Solution so = new _662Solution();
        // 1,3,2,5,3,null,9
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(3);
        TreeNode n7 = new TreeNode(9);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n7;
        so.widthOfBinaryTree(root);

    }
}
