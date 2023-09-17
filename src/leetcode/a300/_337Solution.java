package leetcode.a300;

import leetcode.util.TreeNode;

/**
 * 一棵二叉树，选择里面的一些节点，要求父子节点不能同时选中，
 * 问所有选择方案中节点值得和最大有多少
 */
public class _337Solution {
   
    /**
     * dp问题,根节点和子节点之间的相互关系
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int selected = node.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }

}
