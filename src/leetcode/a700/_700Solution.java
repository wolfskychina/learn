package leetcode.a700;

import leetcode.util.TreeNode;
/**
 * 二叉树遍历
 * {easy}
 */
public class _700Solution {
   
    public TreeNode searchBST(TreeNode root, int val) {

        TreeNode p = traverse(root,val);
        return p;
    }

    private TreeNode traverse(TreeNode p,int val){
        if(p==null) return null;
        if(p.val == val) return p;
        TreeNode l = traverse(p.left,val);
        TreeNode r = traverse(p.right,val);
        return l==null?r:l;
    }
}
