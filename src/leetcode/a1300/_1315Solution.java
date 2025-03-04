package leetcode.a1300;

import leetcode.util.TreeNode;

/**
 * 祖父节点值为偶数的节点和
 * {binary tree},{easy}
 */
public class _1315Solution {

    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {

        traverse(root, 1, 1);

        return sum;
    }

    private void traverse(TreeNode p, int grand, int parent) {

        if (grand % 2 == 0)
            sum += p.val;
        if (p.left != null)
            traverse(p.left, parent, p.val);
        if (p.right != null)
            traverse(p.right, parent, p.val);

    }
}
