package leetcode.a900;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeNode;

/**
 * 设计完全二叉树插入器
 * {design},{binary tree}
 */
public class _919Solution {

    /**
     * 本质上是层次遍历，注意初始化的时候已经有一颗树
     * 需要找到待插入的父节点的位置
     */
    class CBTInserter {
        Queue<TreeNode> cur;
        Queue<TreeNode> next;
        TreeNode root;
    
        public CBTInserter(TreeNode root) {
            this.root = root;
            cur = new LinkedList<>();
            next = new LinkedList<>();
    
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                next = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode qe = q.poll();
                    if (qe.left != null) {
                        next.offer(qe.left);
                        q.offer(qe.left);
                    }
                    if (qe.right != null) {
                        next.offer(qe.right);
                        q.offer(qe.right);
                    }
                    if (qe.left == null || qe.right == null) {
                        cur.offer(qe);
                        for (int j = i + 1; j < size; j++) {
                            cur.offer(q.poll());
                        }
                        return;
                    }
                }
    
            }
        }
    
        public int insert(int val) {
            TreeNode p = cur.peek();
            TreeNode in = new TreeNode(val);
            if (p.left == null) {
                p.left = in;
            } else {
                p.right = in;
                cur.poll();
            }
            next.offer(in);
    
            if (cur.size() == 0) {
                cur = next;
                next = new LinkedList<>();
            }
            return p.val;
    
        }
    
        public TreeNode get_root() {
            return root;
        }
    }
}
