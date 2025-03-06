package leetcode.a100;

import java.util.ArrayDeque;

import leetcode.util.TreeNode;

/**
 * 二叉树到根节点的最短路径长度
 * 最短路径上必须包含叶子结点
 * {binary tree}
 */
public class _111Solution {

    private int h = 1;
    private int max = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {

        // 和最长路径不同，root==null情况需要单独考虑
        if (root == null)
            return 0;

        inOrder(root);
        return max;
    }

    // 实际上是层次遍历
    private void inOrder(TreeNode p) {

        if (p == null)
            return;

        // 当明确一个节点是叶子节点的时候，才能够更新
        if (p != null && p.left == null && p.right == null) {
            if (h <= max)
                max = h;
            return;
        }

        h++;
        inOrder(p.left);
        inOrder(p.right);
        h--;
    }

    // private int h=1;

    /**
     * 实际上不使用高度的全局变量也可以，只需要路径上的局部信息
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {

        if (root == null)
            return 0;
        inOrder(root, 1);
        return max;
    }

    private void inOrder(TreeNode p, int h) {

        if (p == null)
            return;

        if (p != null && p.left == null && p.right == null) {
            if (h <= max)
                max = h;
            return;
        }

        h++;
        inOrder(p.left, h);
        inOrder(p.right, h);
        // h--;
    }

    /**
     * 使用层次遍历在测试用例上明显更快
     * 主要是会首先遇到最短路径的叶节点
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) {
                    return depth;
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
