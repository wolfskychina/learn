package leetcode.a200;

import java.util.HashMap;
import java.util.Map;

public class _105Solution {
   
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
    
    public TreeNode buildTree(int[] preorder, int[] inorder){
    
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
    
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        return helper(0, 0, inorder.length-1, preorder, inorder,inMap);
      }

      // 中根序列的两个索引只是起到固定递归调用的边界，计算终止条件的作用
      public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inMap){
        
        if(preStart > preorder.length-1 || inStart >inEnd){
            return null;
        }
        
        TreeNode root= new TreeNode(preorder[preStart]);
    
    
        // 使用hash快速的定位当前的根节点在中根遍历序列中的索引位置
        // 相当于使用O（n）的额外空间，使得时间复杂性由O(n2)降低到O(n)
        int inIndex = inMap.get(preorder[preStart]);
        
        root.left  = helper(preStart +1, inStart, inIndex-1, preorder, inorder, inMap);
        // inIndex-inStart root左子树节点的个数，前驱队列跳过这些节点数，就是右子树的根节点的起始位置
        root.right = helper(preStart + inIndex-inStart +1, inIndex+1,inEnd, preorder, inorder,inMap);
        return root;
      }
}
