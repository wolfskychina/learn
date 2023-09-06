package leetcode.a100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输出从树的右侧的视图
 * 层次遍历输出每层的最后一个节点
 */
public class _199Solution {

    /**
     * Definition for a binary tree node.
    */
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        if(root == null) return res ;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode right = new TreeNode();


        while(!queue.isEmpty()){

            int qlength = queue.size();
            for(int i=0;i<qlength;i++){

                TreeNode node = queue.poll();
                if(node.left !=null ) queue.offer(node.left);
                if(node.right !=null ) queue.offer(node.right);
                right = node;
            }

            res.add(right.val);

        }

        return res;
    }
}
