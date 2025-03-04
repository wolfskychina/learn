package leetcode.a600;

import leetcode.util.TreeNode;
/**
 * 一种特殊二叉树中第二小的值
 * 二叉树要么没有子节点，要么有两个子节点
 * 父节点的值 = 两个子节点值的最小值
 * {binary tree}
 */
public class _671Solution {

    int min = -1;
    int min2 = -1;
   
    public int findSecondMinimumValue(TreeNode root) {

        traverse(root);
        return min2;
        
    }

    /** 
     * 当目前只出现了一个最小值的情况下，一个子节点的值等于父节点时，需要继续向下递归
     * @param p
     */
    private void traverse(TreeNode p) {

        if(p==null) return;
        if(min == -1){
            min =p.val;
        }else if(p.val>min && (min2 ==-1 || p.val<min2)){
            min2 =p.val;
        }else if(p.val!=min){
            // 如果节点值是最小值，不能直接返回，后续可能有次小值
            return;
        }

        traverse(p.left);
        traverse(p.right);
    }
}
