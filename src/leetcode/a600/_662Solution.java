package leetcode.a600;

import java.util.ArrayDeque;
import java.util.Deque;

import leetcode.util.TreeNode;

public class _662Solution {

    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        if (root == null)
            return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Deque<TreeNode> qq = new ArrayDeque<>();
            TreeNode n = q.poll();
            if (n == null) {
                qq.offer(null);
                qq.offer(null);
            } else {
                qq.offer(n.left);
                qq.offer(n.right);
            }

            while (!qq.isEmpty() && qq.peekFirst() == null)
                qq.pollFirst();
            while (!qq.isEmpty() && qq.peekLast() == null)
                qq.pollLast();
            if (qq.isEmpty())
                break;
            max = Math.max(max, qq.size());
            q = qq;
        }

        return max;

    }

    public static void main(String[] args){

        _662Solution so = new _662Solution();
        //1,3,2,5,3,null,9
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(3);
        TreeNode n7 = new TreeNode(9);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n7;
        so.widthOfBinaryTree(root);
        
    }
}
