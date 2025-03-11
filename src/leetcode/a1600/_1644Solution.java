package leetcode.a1600;

import leetcode.util.TreeNode;

/**
 * 二叉树的最近公共祖先
 * {binary tree},{lca}
 */
public class _1644Solution {

    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        find(root, p, q);
        return res;
    }

    private TreeNode find(TreeNode cur, TreeNode p, TreeNode q) {

        if(res!=null) return null;
        if (cur == null)
            return null;
        TreeNode l = find(cur.left, p, q);
        TreeNode r = find(cur.right, p, q);
        if (l == p && r == q || l == q && r == p) {
            res = cur;
            return cur;
        }
        if (cur == p && (l == q || r == q)) {
            res = cur;
            return cur;
        }
        if (cur == q && (l == p || r == p)) {
            res = cur;
            return cur;
        }
        if (cur == q || cur == p)
            return cur;
        if (l != null)
            return l;
        if (r != null)
            return r;
        return null;

    }
}
