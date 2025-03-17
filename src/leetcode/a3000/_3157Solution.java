package leetcode.a3000;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

/**
 * 找到具有最小和的层数
 * 简单层次遍历
 * {binary tree},{easy}
 */
public class _3157Solution {

    public int minimumLevel(TreeNode root) {
        long min = Long.MAX_VALUE;
        long sum = 0L;
        int res = 0;

        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        int level = 1;

        while (q.size() != 0) {

            List<TreeNode> qnext = new ArrayList<>();
            sum = 0L;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode n = q.get(i);
                sum += n.val;
                if (n.left != null) {
                    qnext.add(n.left);
                }
                if (n.right != null) {
                    qnext.add(n.right);
                }
            }

            if (sum < min) {
                min = sum;
                res = level;
            }
            q = qnext;
            level++;
        }

        return res;
    }
}
