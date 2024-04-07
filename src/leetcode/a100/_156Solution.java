package leetcode.a100;

import leetcode.util.TreeNode;
/**
 * 每层上下翻转二叉树
 * {binary tree}
 * @param root
 * @return
 */
public class _156Solution {
   
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode parent = null, parent_right = null;
        while(root != null){
            TreeNode root_left = root.left;
            root.left = parent_right;
            parent_right = root.right;
            root.right = parent;
            parent = root;
            root = root_left;
        }
        return parent;
    }
}
