package leetcode.a700;

import leetcode.util.TreeNode;

/**
 * bst插入节点
 * {bst}
 */
public class _701Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null)
            return new TreeNode(val);
        TreeNode res = root;
        TreeNode p = null;
        int dir = 0;
        while (root != null) {
            p = root;

            if (root.val < val) {
                root = root.right;
                dir = 1;
            } else {
                root = root.left;
                dir = -1;
            }
        }
        if (dir == -1) {
            p.left = new TreeNode(val);
        } else {
            p.right = new TreeNode(val);
        }

        return res;

    }
}
