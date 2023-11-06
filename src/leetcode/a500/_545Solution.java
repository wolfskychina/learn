package leetcode.a500;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;
/**
 * 寻找二叉树边界值，包括根、左边界、底边、右边界
 * 
 */
public class _545Solution {

    /**
     * {binary tree},{inorder traverse}
     * @param root
     * @return
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        if (root == null)
            return null;
        List<Integer> res = new LinkedList<>();
        // root
        res.add(root.val);
        // left boundry
        if (root.left != null) {
            TreeNode tmp = root.left;
            while (tmp.left != null || tmp.right != null) {
                res.add(tmp.val);

                if (tmp.left != null) {
                    tmp = tmp.left;
                } else {
                    tmp = tmp.right;
                }
            }
        }

        // botom boundry
        inorder(root, res);

        Queue<Integer> q = new LinkedList<>();

        // right boundry
        if (root.right != null) {

            TreeNode tmp = root.right;
            while (tmp.left != null || tmp.right != null) {

                q.offer(tmp.val);

                if (tmp.left == null) {
                    tmp = tmp.right;
                } else {
                    tmp = tmp.left;
                }
            }
        }
        while (!q.isEmpty()) {

            res.add(q.poll());
        }

        return res;

    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        inorder(root.left, res);

        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        inorder(root.right, res);
    }
}
