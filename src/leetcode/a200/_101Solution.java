package leetcode.a200;

public class _101Solution {
   
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSymmetric(TreeNode root) {
       
        return isSameTree(root, root);
    
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q){
        
        if(p==null && q ==null) return true;
        if((p==null && q!=null)||
          (p!=null && q==null)){
            return false;
        }
        
        return (p.val ==q.val)&&isSameTree(p.left, q.right)&&isSameTree(p.right, q.left);
    }
}
