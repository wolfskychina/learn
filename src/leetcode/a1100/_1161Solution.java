package leetcode.a1100;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeNode;

/**
 * 二叉树最大层内元素和
 * {binary tree},{queue},{easy}
 */
public class _1161Solution {

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {

        int maxLevel = 1;
        int maxSum = root.val;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int layer = 1;
        while (!q.isEmpty()) {

            int sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.poll();
                sum += tmp.val;
                if (tmp.left != null)
                    q.offer(tmp.left);
                if (tmp.right != null)
                    q.offer(tmp.right);

            }

            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = layer;
            }

            layer++;

        }

        return maxLevel;

    }
}
