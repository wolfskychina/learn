package leetcode.a1300;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeNode;

/**
 * 层数最深的叶子节点的和
 * {easy}
 */
public class _1302Solution {
   
    /**
     * 二叉树层次遍历
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {

        return levelTraverse(root);

    }

    private int levelTraverse(TreeNode p) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(p);
        int res = 0;
        while (!q.isEmpty()) {
            int num = q.size();
            int sum = 0;
            for (int i = 0; i < num; i++) {
                TreeNode tmp = q.poll();
                sum += tmp.val;
                if (tmp.left != null)
                    q.offer(tmp.left);
                if (tmp.right != null)
                    q.offer(tmp.right);

            }
            res = sum;

        }
        return res;
    }
}
