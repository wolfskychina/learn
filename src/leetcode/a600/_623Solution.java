package leetcode.a600;

import leetcode.util.TreeNode;

public class _623Solution {
    int height = 0;

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        return addRow(root, val, 1, depth);

    }

    private TreeNode addRow(TreeNode p, int val, int curDepth, int target) {

        if (p == null)
            return null;
        if (curDepth + 1 == target) {
            TreeNode node1 = new TreeNode(val);
            TreeNode node2 = new TreeNode(val);
            node1.left = p.left;
            node2.right = p.right;
            p.left = node1;
            p.right = node2;

        } else {
            addRow(p.left, val, curDepth + 1, target);
            addRow(p.right, val, curDepth + 1, target);
        }
        return p;
    }
}
