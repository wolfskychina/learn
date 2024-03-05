package leetcode.a100;

import leetcode.util.TreeNode;

/**
 * 根据一个有序数组构建平衡bst
 * {binary tree}
 */
public class _108Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        
        if(nums ==null || nums.length ==0) return null;
          
        return helper(nums, 0, nums.length-1);
    }
    
    private TreeNode helper(int[] nums, int l, int r){
        
        if(l>r) return null;
        
        // 注意这个地方的括号，一开始写成了 l+(r-l)>>1  ,这个>>的优先级很低。
        // 先算术运算，后移位运算，最后位运算
        int rootIdx = l+((r-l)>>1);
        TreeNode root= new TreeNode(nums[rootIdx]);
        root.left = helper(nums, l,rootIdx-1);
        root.right = helper(nums,rootIdx+1,r);
        return root;
    } 
}
