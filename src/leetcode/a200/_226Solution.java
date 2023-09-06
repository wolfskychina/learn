package leetcode.a200;

import leetcode.util.TreeNode;

/**
 * 将二叉树做镜像对称转换
 */
public class _226Solution {
   
    /**
     * 递归转换，将左右子树互换
     */
    public TreeNode invertTree(TreeNode root) {

        if(root==null) return null;
        TreeNode tmp ;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
