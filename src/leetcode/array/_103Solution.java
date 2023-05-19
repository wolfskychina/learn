package leetcode.array;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ZigZag的方式层次遍历二叉树
 */
public class _103Solution {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>>res = new ArrayList<List<Integer>>();
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        int size = 0;
        TreeNode p =null;
        
        int d =1;
        
        while(q.size()!=0){
            
            LinkedList<Integer> list = new LinkedList<Integer>();
            size = q.size();
            
            for(int i =0;i<size;i++){


                p = q.poll();
      
                if(d==1){
                    list.add(p.val);}
                else{
                    // 注意这个list必须显式的声明为LinkedList
                    // List接口类型没有addFirst，LinkedList有
                    list.addFirst(p.val);
                }
                
                if(p.left !=null){
                  
                    q.offer(p.left);
                }
                if(p.right!=null){
                   
                    q.offer(p.right);
                }
                
            }
            
            d ^=1;
            res.add(list);
        }
        
        return res;
    
    }
}
