package leetcode.a100;

import leetcode.util.TreeNode;
/**
 * 判断两棵二叉树是不是对称的
 * {binary tree}
 */
public class _101Solution {
   
    public boolean isSymmetric(TreeNode root) {
       
        return isSameTree(root, root);
    
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q){
        
        if(p==null && q ==null) return true;
        if((p==null && q!=null)||
          (p!=null && q==null)){
            return false;
        }
        
        // == 的优先级高于 &&,所以这里不加括号也可以
        return p.val ==q.val &&isSameTree(p.left, q.right)&&isSameTree(p.right, q.left);
    }
}
