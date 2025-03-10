package leetcode.a1000;

import leetcode.util.TreeNode;

/**
 * 删除所有根到叶节点上的不足节点
 * 不足节点是指经过该节点的所有从根到叶子节点的路径的元素和均小于limit
 * {binary tree}
 */
public class _1080Solution {

    /**
     * 返回的时候进行判断
     * @param root
     * @param limit
     * @return
     */
    public TreeNode sufficientSubset(TreeNode root, int limit) {

        return deal(root, limit, 0) < limit ? null : root;
    }

    private int deal(TreeNode p, int limit, int prefixsum) {

        if (p == null)
            return -100001;
        if (p.left == null && p.right == null)
            return prefixsum + p.val;
        int l = deal(p.left, limit, prefixsum + p.val);
        int r = deal(p.right, limit, prefixsum + p.val);
        if (l < limit)
            p.left = null;
        if (r < limit)
            p.right = null;
        if (l < limit && r < limit)
            return l;
        if (l >= limit)
            return l;
        else
            return r;

    }
}
