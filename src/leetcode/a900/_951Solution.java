package leetcode.a900;

import leetcode.util.TreeNode;

/**
 * 判断两个树是否是翻转等价二叉树
 * 翻转等价是指可以将任意数量的节点的左右子树进行交换
 * {binary tree}
 */
public class _951Solution {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return true;
        if (root1 != null && root2 == null) {
            return false;
        }
        if (root1 == null && root2 != null)
            return false;
        if (root1.val != root2.val)
            return false;
        return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left) ||
                flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
    }
}
