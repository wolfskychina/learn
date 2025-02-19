package leetcode.a1100;

import leetcode.util.TreeNode;

/**
 * 二叉树着色问题
 * 两个人选二叉树中得两个点，然后以自己得点往相邻点扩展
 * 已知先手选得点，作为后手能否保证自己最终着色得点更多
 * {binary tree},{greedy}
 */
public class _1145Solution {

    private int x, lsz, rsz;

    /**
     * 已经选得x点只能向上或者向左下右下三个方向扩展
     * 后手最佳策略是选择这三个方向中节点最多的，且在x点旁边堵住
     * 看这个方向的节点数
     * 是否会超过另外两个方向的节点数之和
     * @param root
     * @param n
     * @param x
     * @return
     */
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        dfs(root);
        return Math.max(Math.max(lsz, rsz), n - 1 - lsz - rsz) * 2 > n;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int ls = dfs(node.left);
        int rs = dfs(node.right);
        if (node.val == x) {
            lsz = ls;
            rsz = rs;
        }
        return ls + rs + 1;
    }
}
