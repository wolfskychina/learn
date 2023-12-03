package leetcode.a700;

import leetcode.util.TreeNode;

/**
 * bst两个节点值差的最小值
 */
public class _783Solution {

    int last = -1;
    int min = Integer.MAX_VALUE;

    /**
     * {easy}
     * 
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        if (root == null)
            return 0;
        minDiffInBST(root.left);
        if (last != -1) {
            min = Math.min(min, root.val - last);
        }
        last = root.val;

        minDiffInBST(root.right);
        return min;

    }
}
