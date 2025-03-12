package leetcode.a200;

import leetcode.util.TreeNode;

/**
 * 查找bst的第k大的节点
 * {bst},{binary tree}
 */
public class _230Solution {

    /**
     * 利用bst的中序遍历从小到大输出的特征
     */
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public void helper(TreeNode n) {
        if (n.left != null)
            helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null)
            helper(n.right);
    }
}
