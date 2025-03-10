package leetcode.a800;

import leetcode.util.TreeNode;

/**
 * 二叉树剪枝
 * 去掉所有不含1的子树
 * {binary tree}
 */
public class _814Solution {

    /**
     * 自底向上在递归返回的时候删点
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {

        return deal(root) ? root : null;
    }

    private boolean deal(TreeNode p) {

        if (p == null)
            return false;

        boolean l = deal(p.left);
        boolean r = deal(p.right);
        if (!l)
            p.left = null;
        if (!r)
            p.right = null;
        return (p.val == 1) || l || r;
    }
}
