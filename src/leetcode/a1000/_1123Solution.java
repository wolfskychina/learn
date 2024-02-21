package leetcode.a1000;

import leetcode.util.TreeNode;
/**
 * 所有最深叶节点的最低公共祖先节点
 */
public class _1123Solution {
   
    private TreeNode ans;
    private int maxDepth = -1; // 全局最大深度

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    /**
     * 在同一个向下递归调用和返回过程中，完成节点左右子树最大深度的计算和
     * 当前节点是否是最大深度子节点的公共祖先
     * @param node
     * @param depth
     * @return
     */
    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, depth); // 维护全局最大深度
            return depth;
        }
        int leftMaxDepth = dfs(node.left, depth + 1); // 获取左子树最深叶节点的深度
        int rightMaxDepth = dfs(node.right, depth + 1); // 获取右子树最深叶节点的深度
        if (leftMaxDepth == rightMaxDepth && leftMaxDepth == maxDepth)
            ans = node;
        return Math.max(leftMaxDepth, rightMaxDepth); // 当前子树最深叶节点的深度
    }
}
