package leetcode.a500;

import leetcode.util.TreeNode;
/**
 * 给二叉树的加括号的先根遍历字符串构建二叉树
 * {binary tree},{recursion},{preorder traversal}
 */
public class _536Solution {

    int idx = 0;

    public TreeNode str2tree(String s) {

        if (s == null || s.length() < 1) {
            return null;
        }
        TreeNode root = buildTree(s);
        return root;

    }

    private TreeNode buildTree(String s) {

        int l = idx;
        while (idx < s.length() && s.charAt(idx) != '(' &&
                s.charAt(idx) != ')') {
            idx++;
        }

        TreeNode node = new TreeNode(Integer.parseInt(s.substring(l, idx)));

        // 这种遍历顺序恰好对应适配()()得情况,在同一层会有两次调用
        // 一次是左子树得(),一次是右子树得()
        if (idx < s.length() && s.charAt(idx) == '(') {
            idx++;
            node.left = buildTree(s);
        }

        if (idx < s.length() && s.charAt(idx) == '(') {
            idx++;
            node.right = buildTree(s);
        }

        if (idx < s.length() && s.charAt(idx) == ')') {
            idx++;
        }

        return node;
    }

    public static void main(String[] args) {
        _536Solution so = new _536Solution();
        String str = "4(2(3)(1))(6(5))";
        so.str2tree(str);
    }
}
