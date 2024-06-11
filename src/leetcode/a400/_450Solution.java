package leetcode.a400;

import leetcode.util.TreeNode;
/**
 * BST中删除目标节点
 * {bst}
 */
public class _450Solution {

    /**
     * 除了需要根据key定位位置
     * 和二叉树中删除一个节点是相同的
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null)
            return root;
        // 除了目标节点，还需要定位他的父节点
        TreeNode p = null;
        TreeNode i = root;
        // i是否是p的左儿子
        boolean left = false;
        while (i != null && i.val != key) {
            p = i;
            if (key < i.val) {
                i = i.left;
                left = true;
            } else if (key > i.val) {
                i = i.right;
                left = false;
            }
        }
        if (i == null)
            return root;

        if (p == null) {
            p = new TreeNode();
            p.left = i;
            left = true;
        }

        if (i.left == null) {
            if (left) {
                p.left = i.right;
                i.right = null;
            } else {
                p.right = i.right;
                i.right = null;
            }
        } else if (i.right == null) {
            if (left) {
                p.left = i.left;
                i.left = null;
            } else {
                p.right = i.left;
                i.left = null;
            }
        } else if (i.right.left == null) {

            if (left) {
                i.right.left = p.left.left;
                p.left = i.right;

                i.right = null;
            } else {
                i.right.left = p.right.left;
                p.right = i.right;
                i.right = null;
            }

        } else {
            // i.right.left !=null
            TreeNode pp = null;
            TreeNode small = i.right;
            while (small.left != null) {
                pp = small;
                small = small.left;
            }
            TreeNode smallright = small.right;
            if (left) {
                p.left = small;
            } else {
                p.right = small;
            }
            small.left = i.left;
            small.right = i.right;
            pp.left = smallright;
            i.left = null;
            i.right = null;
        }

        // 细节：如果节点数只有1且根节点要被删除，需要特殊处理
        return root.val == key? p.left:root;

    }
}
