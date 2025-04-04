package leetcode.a200;

import leetcode.util.TreeNode;

/**
 * 寻找一个bst里面两个节点的lca最近祖父
 * {bst},{lca},{binary tree}
 */
public class _235Solution {

    /**
     * p和q在lca的左右子树上
     * 
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else
            return root;
    }
}
