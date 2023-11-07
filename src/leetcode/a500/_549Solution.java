package leetcode.a500;

import leetcode.util.TreeNode;
/**
 * 二叉树中最长的连续序列
 * 递增和递减序列均算连续序列
 */
public class _549Solution {

    int max = 0;
    int max1 = 0;

    /**
     * {postorder traverse}后根遍历
     * 需要保存终点为每个节点的上升序列和下降序列的最大值
     * 然后根据左右子节点的上升下降序列，计算经过每个节点的最长上升和下降序列
     * 
     * @param root
     * @return
     */
    public int longestConsecutive(TreeNode root) {

        postOrderTraverse(root);

        return Math.max(max, max1);
    }

    private int[] postOrderTraverse(TreeNode node) {

        if (node == null)
            return null;
        int left[] = postOrderTraverse(node.left);
        int right[] = postOrderTraverse(node.right);

        int length = ((node.left != null && node.left.val + 1 == node.val) ? left[0] : 0) + 1 +
                ((node.right != null && node.right.val - 1 == node.val) ? right[1] : 0);

        int length1 = ((node.left != null && node.left.val == node.val + 1) ? left[1] : 0) + 1 +
                ((node.right != null && node.right.val == node.val - 1) ? right[0] : 0);
        max = Math.max(max, length);
        max1 = Math.max(max1, length1);

        int len3 = Math.max((node.left != null && node.left.val + 1 == node.val) ? left[0] + 1 : 1,
                (node.right != null && node.right.val + 1 == node.val) ? right[0] + 1 : 1);

        int len4 = Math.max((node.left != null && node.left.val - 1 == node.val) ? left[1] + 1 : 1,
                (node.right != null && node.right.val - 1 == node.val) ? right[1] + 1 : 1);
        return new int[] { len3, len4 };

    }
}
