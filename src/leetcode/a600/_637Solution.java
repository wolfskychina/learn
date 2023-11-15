package leetcode.a600;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;
/**
 * 二叉树每层的平均值
 */
public class _637Solution {

    /**
     * 层次遍历
     * {easy}
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {

            int len = q.size();
            double avg = 0;
            for (int i = 0; i < len; i++) {
                TreeNode n = q.poll();
                avg += n.val;
                if (n.left != null)
                    q.offer(n.left);
                if (n.right != null)
                    q.offer(n.right);
            }
            res.add(avg / len);

        }
        return res;
    }
}
