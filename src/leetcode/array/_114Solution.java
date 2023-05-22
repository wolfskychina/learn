package leetcode.array;

/**
 * 将一个二叉树拍扁成只有右子树的队列
 * 
 */
public class _114Solution {
   
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {
        
        if(root ==null) return ;
        
        TreeNode p =root;
        TreeNode last = null;


        while(p!=null){
            if(p.left ==null){
                p = p.right;
                continue;
            }
            last = p.left;
            // 找到左子树先根遍历顺序最后得节点（右下方）
            while(last.right!=null){
                last = last.right;
            }
            // 把last和p原来的右节点接上
            last.right = p.right;
            p.right = p.left;
            p.left =null;
            
            p = p.right;
        }
        
        return ;
    }
}
