package leetcode.a300;

import leetcode.util.TreeNode;

/**
 * 求一个二叉树中，最长的连续向下递增分支的长度
 * 连续向下递增分支是指节点从上往下值依次加1
 */
public class _298Solution {
    int max = 0;

    public int longestConsecutive(TreeNode root) {

        if (root == null) return max;
        findLongest(root.left, root.val, 1);
        findLongest(root.right, root.val, 1);
        return max;

    }

    private void findLongest(TreeNode p, int last, int length) {

        if (p == null) {
            max = Math.max(max, length);
            return;
        }
        if (p.val == last + 1) {
            last++;
            length++;
        } else {
            max = Math.max(max, length);
            last = p.val;
            length = 1;
        }
        findLongest(p.left, last, length);
        findLongest(p.right, last, length);
        return;

    }

}
