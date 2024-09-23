package leetcode.a1000;

import leetcode.util.TreeNode;

/**
 * 统计二叉树中好节点的数目
 * 好节点是指从 root到当前节点的路径中不存在比当前节点值大的节点
 * {binary tree},{easy} 
 */
public class _1448Solution {

    int num = 0;

    public int goodNodes(TreeNode root) {

        count(root, root.val);
        return num;
    }

    private void count(TreeNode p, int maxCur) {
        if (p == null)
            return;

        if (maxCur <= p.val)
            num++;
        int next = Math.max(maxCur, p.val);
        count(p.left, next);
        count(p.right, next);
    }
}
