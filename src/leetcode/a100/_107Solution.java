package leetcode.a100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;
/**
 * 自底向上的层次遍历二叉树
 * {binary tree}
 */
public class _107Solution {
   
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        LinkedList<List<Integer>> res= new LinkedList<List<Integer>>();
        if(root ==null ){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            
            res.addFirst(list);
        }
        
        return res;
        
    }
}
