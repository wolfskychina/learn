package leetcode.a100;

import leetcode.util.TreeNode;

/**
 * 二叉树中所有节点对之间距离的最大值
 * {binary tree},{greedy}
 */
public class _124Solution {

    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    // 通过遍历每个节点，计算出最大值
    // 符合贪心规则
    private int maxPathDown(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        // 通过当前节点的最大路径的值
        maxValue = Math.max(maxValue, left + right + node.val);
        // 返回
        return Math.max(left, right) + node.val;
    }
}