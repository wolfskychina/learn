package leetcode.a100;

import leetcode.util.TreeNode;

/**
 * 判断两棵BST是否相同，只要值和结构相同就认为相同
 * 类似的任何二叉树也可以这么判断
 * {bst},{binary tree}
 */
public class _100Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;
        if ((p == null && q != null) ||
                (p != null && q == null)) {
            return false;
        }

        return isSameTree(p.left, q.left) && (p.val == q.val) && isSameTree(p.right, q.right);
    }
}
