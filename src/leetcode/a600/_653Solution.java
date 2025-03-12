package leetcode.a600;

import leetcode.util.TreeNode;

/**
 * 判断BST中是否存在两数之和等于k
 * {bst},{binary tree}
 */
public class _653Solution {

    int a[];
    boolean res = false;

    public boolean findTarget(TreeNode root, int k) {
        if (k < -20000 || k > 20000)
            return false;
        a = new int[20001];// 数组要开足够大
        dfs(root, k);

        return res;
    }

    public void dfs(TreeNode node, int k) {

        if (node == null)
            return;

        dfs(node.left, k);

        // 因为k的取值范围，要特别注意数组索引不会越界
        if (k - node.val + 10000 >= 0 && k - node.val + 10000 <= 20001 && a[k - node.val + 10000] > 0) {
            res = true;
            return;
        }
        // 先判断再更新
        a[node.val + 10000] = 1;
        dfs(node.right, k);
    }
}
