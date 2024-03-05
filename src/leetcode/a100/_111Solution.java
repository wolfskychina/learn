package leetcode.a100;

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
}
