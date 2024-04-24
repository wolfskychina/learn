package leetcode.a2000;

import leetcode.util.TreeNode;

/**
 * 二叉树中的一个节点开始感染相邻的节点（包括上下方向）
 * 问需要多少时间会将整个二叉树感染
 * 相当于求距离该节点最远的节点
 * {binary tree},{dfs}
 */
public class _2385Solution {

    int ans = 0;
    int startHeight = 0;

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return ans;
    }

    /**
     * 深度优先搜索。返回两个值，一个是子树的高度，另一个是子树内部是否包含start
     * 如果两个子树内部有一个包含start，那就更新路径的最大值
     */
    public int dfs(TreeNode node, int start) { // 返回node所在高度，若包含start就返回负的高度
        if (node == null)
            return 0;
        int l = dfs(node.left, start);
        int r = dfs(node.right, start);

        if (node.val == start) {
            startHeight = Math.max(l, r) + 1;
            ans = Math.max(ans, startHeight - 1);
            return -startHeight;
        }

        if (l < 0 || r < 0) { // start在左右子树中
            ans = Math.max(ans, (l < 0 ? r - l : l - r) + 1 - startHeight);
            return (l < 0 ? l - 1 : r - 1);
        }

        return Math.max(l, r) + 1;
    }
}
