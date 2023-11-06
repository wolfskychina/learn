package leetcode.a500;

import leetcode.util.TreeNode;

/**
 * 计算二叉树的直径
 * 二叉树的直径指任意两点间最长的距离
 * {binary tree}
 */
public class _543Solution {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        calculateDiameter(root);

        return max;

    }

    public int calculateDiameter(TreeNode root) {

        int left = root.left == null ? 0 : (calculateDiameter(root.left) + 1);
        int right = root.right == null ? 0 : (calculateDiameter(root.right) + 1);
        max = Math.max(max, left + right);
        return left > right ? left : right;
    }

    public static void main(String[] args) {

        _543Solution so = new _543Solution();
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;

        so.diameterOfBinaryTree(root);
    }
}
