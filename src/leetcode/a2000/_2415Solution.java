package leetcode.a2000;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeNode;

/**
 * 翻转二叉树的奇数层
 * {binary tree}二叉树的层次遍历
 */
public class _2415Solution {

    public TreeNode reverseOddLevels(TreeNode root) {
        levelTraverse(root);
        return root;

    }

    private void levelTraverse(TreeNode p) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(p);

        int level = 0;
        while (!q.isEmpty()) {
            int num = q.size();
            TreeNode[] arr = new TreeNode[num];

            for (int i = 0; i < num; i++) {
                TreeNode tmp = q.poll();
                arr[i] = tmp;
                if (tmp.left != null)
                    q.offer(tmp.left);
                if (tmp.right != null)
                    q.offer(tmp.right);
            }
            if (level % 2 == 1) {
                for (int i = 0; i < arr.length / 2; i++) {
                    int t = arr[i].val;
                    arr[i].val = arr[arr.length - 1 - i].val;
                    arr[arr.length - 1 - i].val = t;
                }
            }
            level++;

        }
        return;
    }
}
