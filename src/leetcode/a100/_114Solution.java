package leetcode.a100;

import leetcode.util.TreeNode;

/**
 * 将一个二叉树拍扁成只有右子树的队列
 * {binary tree}
 * 
 */
public class _114Solution {

    public void flatten(TreeNode root) {

        if (root == null)
            return;

        TreeNode p = root;
        TreeNode last = null;

        while (p != null) {
            if (p.left == null) {
                p = p.right;
                continue;
            }
            last = p.left;
            // 找到左子树先根遍历顺序最后得节点（右下方）
            while (last.right != null) {
                last = last.right;
            }
            // 把last和p原来的右节点接上
            // 缝合关键节点
            last.right = p.right;
            p.right = p.left;
            p.left = null;

            p = p.right;
        }

        return;
    }
}
