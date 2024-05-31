package leetcode.a400;

import leetcode.util.TreeNode;
/**
 * 二叉树中所有左叶子节点（是父节点的左儿子的叶子结点）的和
 * {binary tree},{easy}
 */
public class _404Solution {
   
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;

        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            sum+= root.left.val; 
        }

        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);

        return sum;

    }
}
