package leetcode.a200;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出一个二叉树到叶子节点的所有路径
 * {binary tree}
 */
public class _257Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();
        if (root == null) return res;

        if (root.left == null && root.right == null) {
            res.add("" + root.val);
            return res;
        }

        findPaths(res, root.left, "" + root.val);
        findPaths(res, root.right, "" + root.val);

        return res;

    }

    private void findPaths(List<String> res, TreeNode p, String list) {
        if (p == null) return;
        if (p.left == null && p.right == null) {
            res.add(list + "->" + p.val);
            return;
        }
        if (p.left != null) findPaths(res, p.left, list + "->" + p.val);
        if (p.right != null) findPaths(res, p.right, list + "->" + p.val);
        return;

    }
}
