package leetcode.a900;

import leetcode.util.TreeNode;

/**
 * 判断一个二叉树中的值是否全都一样
 * {easy}
 */
public class _965Solution {

    private boolean res = true;
    private int i;

    public boolean isUnivalTree(TreeNode root) {

        i = root.val;

        traverse(root);
        return res;

    }

    private void traverse(TreeNode p) {

        if (res == false || p.val != i) {
            res = false;
            return;
        }

        if (p.left != null)
            traverse(p.left);
        if (p.right != null)
            traverse(p.right);
    }
}
