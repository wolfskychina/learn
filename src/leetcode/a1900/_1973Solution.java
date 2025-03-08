package leetcode.a1900;

import leetcode.util.TreeNode;

/**
 * 节点值和子树节点值之和相等的节点的个数
 * {binary tree},{easy}
 */
public class _1973Solution {

    int res = 0;

    public int equalToDescendants(TreeNode root) {

        dfs(root);
        return res;
    }

    private int dfs(TreeNode p) {
        if (p == null)
            return 0;
        int l = dfs(p.left);
        int r = dfs(p.right);
        if (l + r == p.val)
            res++;
        return l + r + p.val;
    }
}
