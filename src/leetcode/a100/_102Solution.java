package leetcode.a100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;
/**
 * 二叉树的层次遍历
 * {binary tree}
 */
public class _102Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>>res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        int size = 0;
        TreeNode p =null;
        
        while(q.size()!=0){
            List<Integer> list = new ArrayList<Integer>();
            size = q.size();
            for(int i =0;i<size;i++){
                
                p = q.poll();
                list.add(p.val);
                
                if(p.left !=null){
                    q.offer(p.left);
                }
                if(p.right!=null){
                    q.offer(p.right);
                }
            }
            res.add(list);
        }
        return res;
    } 
}
