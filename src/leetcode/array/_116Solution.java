package leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给满二叉树增加层次遍历的节点指针
 */
public class _116Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root ==null) return null;
        
        Queue<Node> q = new LinkedList<Node>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            Node p = q.poll();
            if(p.left!=null) q.offer(p.left);
            if(p.right!=null) q.offer(p.right);
            for(int i=1;i<size;i++){
                
                p.next = q.poll();
                if(p.next.left!=null) {q.offer(p.next.left);}
                if(p.next.right!=null) {q.offer(p.next.right);}
                p = p.next;
            }
            p.next = null;
        }
        
        return root;
        
    } 
}
