package leetcode.a500;

import leetcode.util.TreeNode;
/**
 * 根据二叉树构建字符串
 * 要求字符串中加括号时采用缩略的形式
 * {binary tree}
 */
public class _606Solution {

    StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode root) {
        firstRootVisit(root);

        return sb.toString();
    }

    private void firstRootVisit(TreeNode p) {
        if (p == null)
            return;
        sb.append(p.val);
        // 注意缩略的形式，如果左子树不为空或者右子树不为空，左子树的（）均不能忽略
        if (p.left != null || p.right != null) {
            sb.append("(");
            firstRootVisit(p.left);
            sb.append(")");

        }

        if (p.right != null) {
            sb.append("(");
            firstRootVisit(p.right);
            sb.append(")");
        }

    }
}
