package leetcode.a500;

import leetcode.util.TreeNode;
/**
 * 输出二叉树最下面一层最左侧的节点的值
 */
public class _513Solution {

    int max = 0;
    TreeNode p;

    public int findBottomLeftValue(TreeNode root) {

        traverse(root, 1);
        return p.val;

    }

    private void traverse(TreeNode node, int level) {

        if (node == null)
            return;

        if (level > max) {
            max = level;
            p = node;
        }
        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }
}
