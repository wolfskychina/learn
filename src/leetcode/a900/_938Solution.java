package leetcode.a900;

import leetcode.util.TreeNode;

/**
 * bst中值在[L,r]之间的节点的和
 * {bst}
 */
public class _938Solution {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);

    }
}
