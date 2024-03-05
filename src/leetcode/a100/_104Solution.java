package leetcode.a100;

import leetcode.util.TreeNode;

/**
 * 二叉树的最大深度
 * {binary tree}
 */
public class _104Solution {

    private int h = 0;
    private int max = 0;

    public int maxDepth(TreeNode root) {

        inOrder(root);
        return max;
    }

    private void inOrder(TreeNode p) {

        if (p == null)
            return;

        h++;
        if (h > max)
            max = h;
        inOrder(p.left);
        inOrder(p.right);
        h--;
    }
}
