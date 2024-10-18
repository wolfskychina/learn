package leetcode.a1300;

import leetcode.util.TreeNode;

/**
 * 二叉树中的最长交错路径
 * {binary tree}
 */
public class _1372Solution {

    int maxL = 0;
    int maxR = 0;

    public int longestZigZag(TreeNode root) {

        traverse(root.left, 1, 0, 0);
        traverse(root.right, 2, 0, 0);
        return Math.max(maxL, maxR);
    }

    private void traverse(TreeNode p, int direction, int curL, int curR) {

        if (p == null)
            return;
        int newL = 0;
        int newR = 0;
        if (direction == 1) {

            newL = curR + 1;
            maxL = Math.max(newL, maxL);

        } else {
            newR = curL + 1;
            maxR = Math.max(newR, maxR);

        }

        traverse(p.right, 2, newL, newR);
        traverse(p.left, 1, newL, newR);
    }
}
