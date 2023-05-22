package leetcode.array;
/**
 * 判断一个bst是否是平衡的
 * 所有子树的左右子树的高度差不超过1
 */
public class _110Solution {
  
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
    int h =0;
    boolean res = true;
    
    public boolean isBalanced(TreeNode root) {
        
        if(root == null) return true;
        height(root);
        return res;
        
    }
    
     private int height(TreeNode p){
        
        if(p== null) return 0;
        if(res == false) return 0;
        
         int l = height(p.left);
         int r = height(p.right);
         
         if(l-r==0 || l-r==1){
             return l+1;
         }else if(r-l ==1){
             return r+1;
         }else{
             res = false;
             return Math.max(l,r)+1;
         }
       
    }
}
