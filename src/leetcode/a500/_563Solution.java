package leetcode.a500;

import leetcode.util.TreeNode;

public class _563Solution {
    int sum = 0;

    public int findTilt(TreeNode root) {

        traverse(root);

        return sum;
    }

    private int traverse(TreeNode p) {
        if (p == null)
            return 0;

        int left = traverse(p.left);
        int right = traverse(p.right);

        sum += Math.abs(left - right);
        return left + right + p.val;
    }
}
