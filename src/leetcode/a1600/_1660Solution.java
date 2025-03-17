package leetcode.a1600;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import leetcode.util.TreeNode;

/**
 * 二叉树中有一个节点的右子树错误的指向了同层右侧的节点
 * 删除这个节点以及它下层的所有节点
 * {binary tree}
 */
public class _1660Solution {

    /**
     * 自己写的方法，比较复杂
     * @param root
     * @return
     */
    public TreeNode correctBinaryTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode toDelete = null;
        while (!q.isEmpty()) {
            int size = q.size();

            Set<TreeNode> set = new HashSet<>();
            List<TreeNode> list = new ArrayList<>();
            TreeNode tar = null;
            for (int i = 0; i < size; i++) {
                TreeNode p = q.poll();
                list.add(p);
                if (set.contains(p)) {
                    tar = p;
                    break;
                }
                if (p.left != null) {
                    q.offer(p.left);
                }
                if (p.right != null) {
                    set.add(p.right);
                    q.offer(p.right);
                }

            }
            if (tar != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).right != null && list.get(i).right == tar) {
                        toDelete = list.get(i);
                        break;
                    }
                }
                break;
            }

        }

        TreeNode parent = findParent(root, toDelete);
        if (parent.left == toDelete) {
            parent.left = null;
        } else {
            parent.right = null;
        }
        return root;
    }

    private TreeNode findParent(TreeNode p, TreeNode toDelete) {

        if(p==null) return null;
        if(p.left==toDelete||p.right==toDelete) return p;
        TreeNode l = findParent(p.left, toDelete);
        if(l!=null) return l;
        TreeNode r = findParent(p.right, toDelete);
        if(r!=null) return r;
        return null;
    }

    Set<Integer> visited = new HashSet<>();
    
    /**
     * 非常简洁的方法
     * @param root
     * @return
     */
    public TreeNode correctBinaryTree1(TreeNode root) {
        if (root == null) return null;
        if (root.right != null && visited.contains(root.right.val)) return null;
        visited.add(root.val);
        root.right = correctBinaryTree(root.right);
        root.left = correctBinaryTree(root.left);
        return root;
    }
}
