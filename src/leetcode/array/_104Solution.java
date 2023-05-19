package leetcode.array;

/**
 * 二叉树的最大深度
 */
public class _104Solution {
   
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

    private int h=0;
    private int max=0;
    
    public int maxDepth(TreeNode root) {
        
        inOrder(root);
        return max;
    }
    
    private void inOrder(TreeNode p){
        
        if(p==null) return;
        
        h++;
        if(h>max) max= h;
        inOrder(p.left);
        inOrder(p.right);
        h--;
    }
}
