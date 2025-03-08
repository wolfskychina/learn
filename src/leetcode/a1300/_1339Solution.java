package leetcode.a1300;

import leetcode.util.TreeNode;

/**
 * 分裂二叉树的最大乘积
 * {binary tree},{easy}
 */
public class _1339Solution {

    long max = 0L;
    int sum = 0;

    public int maxProduct(TreeNode root) {

        computeSum(root);

        computeMax(root);

        return (int) (max % (1e9 + 7));
    }

    private void computeSum(TreeNode p) {
        if (p == null)
            return;
        sum += p.val;
        computeSum(p.left);
        computeSum(p.right);
    }

    private int computeMax(TreeNode p) {
        if (p == null)
            return 0;

        int l = computeMax(p.left);
        int r = computeMax(p.right);
        int tmp = l + r + p.val;
        max = Math.max((long) tmp * (sum - tmp), max);
        return tmp;
    }
}
