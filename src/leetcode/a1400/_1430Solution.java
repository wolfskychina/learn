package leetcode.a1400;

import leetcode.util.TreeNode;

/**
 * 判断给定的序列是否是二叉树从根节点到叶节点的路径
 * {binary tree}
 */
public class _1430Solution {

    public boolean isValidSequence(TreeNode root, int[] arr) {

        return check(root, 0, arr);

    }

    private boolean check(TreeNode p, int idx, int[] arr) {

        if (p == null)
            return false;
        if (idx == arr.length - 1) {
            // 符合要求的终止条件有多个需要满足
            if (p.val == arr[idx] && p.left == null && p.right == null) {
                return true;
            } else {
                return false;
            }
        }
        if (p.val == arr[idx]) {
            return check(p.left, idx + 1, arr) || check(p.right, idx + 1, arr);
        } else {
            return false;
        }
    }
}
