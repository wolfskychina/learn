package leetcode.array;

/**
 * 判断二叉树中是否有节点数值之和为sum的路径
 */
public class _112Solution {
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

    private int sum2=0;
    private boolean res = false;
    
    public boolean hasPathSum(TreeNode root, int sum) {
        
        countSum(root, sum2, sum);
        return res;
    }
    
    private void countSum(TreeNode p, int sum2, int sum){
        if(p==null || res == true) return ;
        
        if(p.left ==null &&p.right ==null && sum2+p.val == sum) {
            res = true;
            return;
        }
        
        countSum(p.left, sum2+p.val, sum);
        countSum(p.right, sum2+p.val, sum);
    }
}
