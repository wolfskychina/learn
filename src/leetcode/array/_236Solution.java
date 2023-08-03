package leetcode.array;

import leetcode.util.TreeNode;

/**
 * 返回二叉树中两个节点的最近公共父节点
 */
public class _236Solution {
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
}
