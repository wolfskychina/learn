package leetcode.a500;

import leetcode.util.TreeNode;
/**
 * bst中两个节点值的绝对差的最小值
 * {bst},{easy}
 */
public class _530Solution {

    int last = -1;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        inOrderTravel(root);

        return min;

    }

    private void inOrderTravel(TreeNode node) {

        if (node == null)
            return;
        inOrderTravel(node.left);

        if (last != -1) {
            min = Math.min(min, Math.abs(node.val - last));
        }

        last = node.val;
        inOrderTravel(node.right);

    }
}
