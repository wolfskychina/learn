package leetcode.a800;

import leetcode.util.TreeNode;
/**
 * 二叉树中一共有同节点一样多的金币，但是每个节点上的金币不一定一样多
 * 问最少移动多少金币，可以使每个节点恰好有一个金币
 * 
 */
public class _979Solution {
   
    private int ans;

    /**
     * {last order travsers},{binary tree}
     * 考虑经过每条边的金币的数量，所有边的总和就是最少移动的次数
     * 考虑子树的边界的边，如果子树中金币比子树中的点多n，那么必然会有n
     * 个金币需要经过边界移动到外面，反之，如果少n就会有n个金币移动到子树中
     * 通过遍历所有子树，找到所有的金币移动需求。
     * {TODO}
     * @param root
     * @return
     */
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node) {
        if (node == null)
            return new int[]{0, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int coins = left[0] + right[0] + node.val; // 子树硬币个数
        int nodes = left[1] + right[1] + 1; // 子树节点数
        ans += Math.abs(coins - nodes);
        return new int[]{coins, nodes};
    }
}
