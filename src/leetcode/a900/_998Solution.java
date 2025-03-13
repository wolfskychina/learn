package leetcode.a900;

import leetcode.util.TreeNode;

/**
 * 根据一个数组构建的最大二叉树，往原来数组后追加一个数字
 * 返回新的数组按照原来的规则生成的最大二叉树
 * {binary tree}
 */
public class _998Solution {

    /**
     * 观察找规律
     * 按照题目给出的规则，val是在数组的最右边，如果有比他大的数
     * 那么val一定出现在这些数的右子树上
     * 如果没有比val更大的数，那么val是数组的最大数，会在第一轮成为根
     * 所以原树会成为val的左子树
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode prev = null, cur = root;
        while (cur != null && cur.val > val) {
            prev = cur;
            cur = cur.right;
        }
        if (prev == null) {
            node.left = cur;
            return node;
        } else {
            prev.right = node;
            node.left = cur;
            return root;
        }
    }
}
