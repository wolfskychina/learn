package leetcode.a600;

import leetcode.util.TreeNode;
/**
 * 二叉树中连续值相同的节点组成的路径的最长长度
 */
public class _687Solution {

    int max = 0;

    /**
     * {binary tree}
     *
     */
    public int longestUnivaluePath(TreeNode root) {

        calLength(root);
        return max;

    }

    private int calLength(TreeNode root) {

        if (root == null)
            return 0;
        int left = calLength(root.left);
        int right = calLength(root.right);
        if (root.left != null && root.right != null && root.left.val == root.val && root.right.val == root.val) {
            max = Math.max(max, left + right + 2);
            return left > right ? left + 1 : right + 1;
        } else if (root.left != null && root.left.val == root.val) {
            max = Math.max(max, left + 1);
            return left + 1;
        } else if (root.right != null && root.right.val == root.val) {
            max = Math.max(max, right + 1);
            return right + 1;
        } else {
            return 0;
        }
    }
}
