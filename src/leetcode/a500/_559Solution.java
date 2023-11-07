package leetcode.a500;

import leetcode.util.narray.Node;

/**
 * N叉树的最大深度
 * {easy}
 */
public class _559Solution {

    int max = 0;

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        dfs(root, 1);
        return max;
    }

    private void dfs(Node p, int height) {

        if (p == null)
            return;
        max = Math.max(max, height);
        for (Node n : p.children) {
            dfs(n, height + 1);
        }
    }
}
