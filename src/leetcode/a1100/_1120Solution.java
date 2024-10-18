package leetcode.a1100;

import leetcode.util.TreeNode;

/**
 * 二叉树所有子树的最大平均值
 * {binary tree}
 */
public class _1120Solution {

    double max = 0;

    public double maximumAverageSubtree(TreeNode root) {

        calSubTree(root);

        return max;
    }

    private Result calSubTree(TreeNode node) {

        if (node == null)
            return new Result(0, 0);

        Result r1 = calSubTree(node.left);
        Result r2 = calSubTree(node.right);

        int sum = r1.sum + r2.sum + node.val;
        // TODO 右边所有都是整数，所以要强制转换成double类型后运算
        // 否则会默认按照整数运算后自动转换成int
        double avg = (double) sum / (r1.num + r2.num + 1);

        max = Math.max(max, avg);

        return new Result(sum, r1.num + r2.num + 1);

    }

    private class Result {
        int sum;
        int num;

        public Result(int sum, int num) {
            this.sum = sum;
            this.num = num;
        }
    }
}
