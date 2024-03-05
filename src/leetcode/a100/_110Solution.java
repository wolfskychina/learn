package leetcode.a100;

import leetcode.util.TreeNode;

/**
 * 判断一个bst是否是平衡的
 * 所有子树的左右子树的高度差不超过1
 * {binary tree}
 */
public class _110Solution {

    int h = 0;
    boolean res = true;

    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;
        height(root);
        return res;

    }

    private int height(TreeNode p) {

        if (p == null)
            return 0;
        if (res == false)
            return 0;

        int l = height(p.left);
        int r = height(p.right);

        if (l - r == 0 || l - r == 1) {
            return l + 1;
        } else if (r - l == 1) {
            return r + 1;
        } else {
            res = false;
            return Math.max(l, r) + 1;
        }
    }
}
