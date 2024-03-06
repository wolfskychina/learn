package leetcode.a100;

import leetcode.util.TreeNode;

/**
 * 判断二叉树中是否有从根节点除法的节点数值之和为sum的路径
 * {binary tree},{easy}
 */
public class _112Solution {

    private boolean res = false;

    public boolean hasPathSum(TreeNode root, int sum) {

        countSum(root, 0, sum);
        return res;
    }

    private void countSum(TreeNode p, int sum2, int sum) {
        if (p == null || res == true)
            return;

        if (p.left == null && p.right == null && sum2 + p.val == sum) {
            res = true;
            return;
        }

        countSum(p.left, sum2 + p.val, sum);
        countSum(p.right, sum2 + p.val, sum);
    }
}
