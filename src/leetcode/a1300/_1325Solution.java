package leetcode.a1300;

import leetcode.util.TreeNode;

/**
 * 删除指定值的叶子节点
 * 如果有节点在某一轮之后变成了叶子结点且值符合，也需要递归的被删除
 * {binary tree}
 */
public class _1325Solution {

    /**
     * 在递归的返回时进行判断删除
     * 根节点的特殊情况需要注意
     * @param root
     * @param target
     * @return
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {

        return remove(root, target) ? null : root;
    }

    private boolean remove(TreeNode p, int tar) {
        if (p == null)
            return false;
        if (remove(p.left, tar))
            p.left = null;
        if (remove(p.right, tar))
            p.right = null;
        if (p.val == tar && p.left == null && p.right == null)
            return true;
        return false;

    }
}
