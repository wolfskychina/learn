package leetcode.a500;

import leetcode.util.TreeNode;
/**
 * 判断一棵二叉树是不是另外一棵树的子树
 */
public class _572Solution {
   
    boolean res = false;
    /**
     * {binary tree},{subtree}
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        int tar = subRoot.val;

        traverse(root,tar,subRoot);
        return res;

    }

    private void traverse(TreeNode p, int val,TreeNode sub){
        if(res == true) return;
        if(p==null) return ;

        if(p.val == val){

            if(compare(p,sub))
                {res = true;
                return;
                }
        }

        traverse(p.left,val,sub);
        traverse(p.right,val,sub);

    }

    private boolean compare(TreeNode p,TreeNode sub){
            if(p==null&&sub==null) return true;
            if((p==null&&sub!=null)||(p!=null&&sub==null)) return false;
            if(p.val != sub.val) return false;

            if(compare(p.left,sub.left)==true && compare(p.right,sub.right))
                return true;
            return false;
    }


    /**
     * 另外一种快很多的方法
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        return helper(root, subRoot, subRoot);
    }

    public boolean helper(TreeNode root, TreeNode subRoot, TreeNode mRoot) {
        if(root == null && subRoot == null) return true;
        if(root != null && subRoot == null) return false;
        if(root == null && subRoot != null) return false;
        if(root.val == subRoot.val) {
            return (helper(root.left, subRoot.left, subRoot) && helper(root.right, subRoot.right, subRoot))
                || helper(root.left, mRoot, mRoot) || helper(root.right, mRoot, mRoot);
        } else {
            return helper(root.left, mRoot, mRoot) || helper(root.right, mRoot, mRoot);
        }
    }
}
