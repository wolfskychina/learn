package leetcode.a2000;

import leetcode.util.TreeNode;
/**
 * 计算布尔二叉树的值
 * {easy}
 * {binary tree}
 */
public class _2331Solution {

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null) {
            return root.val == 1;
        }
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }

}
