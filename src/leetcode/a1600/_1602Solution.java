package leetcode.a1600;

import leetcode.util.TreeNode;

/**
 * 找到二叉树中目标节点最近的右侧节点
 * 如果没有，就返回null
 * {binary tree},{dfs}
 */
public class _1602Solution {

    boolean found = false;
    int l = -1;
    TreeNode res = null;

    /**
     * 利用了先根遍历（深度优先）同一层的节点左边先访问的特点
     * 一趟遍历中查找目标节点和他右边的节点
     * 
     * @param root
     * @param u
     * @return
     */
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {

        dfs(root, u, 0);
        return res;
    }

    private void dfs(TreeNode p, TreeNode tar, int level) {
        if (p == null)
            return;

        if (p == tar) {
            found = true;
            l = level;
            return;
        }
        if (res != null)
            return;
        // if(l!=-1&&level>l) return;
        if (found && level == l) {
            res = p;
            return;
        }
        dfs(p.left, tar, level + 1);
        dfs(p.right, tar, level + 1);
    }
}
