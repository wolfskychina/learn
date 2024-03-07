package leetcode.a100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.util.TreeNode;

/**
 * 先根遍历二叉树
 * {binary tree}
 */
public class _144Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        Stack<TreeNode> s = new Stack<TreeNode>();

        s.push(root);

        while (!s.empty()) {

            TreeNode node = s.pop();
            res.add(node.val);
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
        }

        return res;
    }
}
