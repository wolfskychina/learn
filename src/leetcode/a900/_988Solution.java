package leetcode.a900;

import leetcode.util.TreeNode;

/**
 * 从叶节点到根节点的路径构成的最小字符串
 * {binary tree},{easy}
 */
public class _988Solution {

    String min = "";

    public String smallestFromLeaf(TreeNode root) {
        min = "";
        StringBuilder s = new StringBuilder();
        traverse(root, s);

        return min;
    }

    private void traverse(TreeNode p, StringBuilder sb) {

        sb.append((char) ('a' + p.val));
        if (p.left == null && p.right == null) {
            String cur = sb.reverse().toString();
            if (min.equals("") || cur.compareTo(min) < 0)
                min = cur;

            // TODO StringBuilder的reverse（）方法会把缓冲区直接反转
            // 所以凡是之前反转过的这里一定要再次反转一遍
            sb.reverse();
            sb.setLength(sb.length() - 1);
            return;
        }
        if (p.left != null)
            traverse(p.left, sb);
        if (p.right != null)
            traverse(p.right, sb);
        sb.setLength(sb.length() - 1);
        return;
    }
}
