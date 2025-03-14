package leetcode.a2000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

/**
 * 二叉树的第k大层和
 * {easy}
 */
public class _2583Solution {

    public long kthLargestLevelSum(TreeNode root, int k) {

        List<Long> res = new ArrayList<>();
        levelTraverse(root, res);
        Collections.sort(res);
        if (k > res.size())
            return -1;
        return res.get(res.size() - k);
    }

    private void levelTraverse(TreeNode p, List<Long> list) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(p);
        while (!q.isEmpty()) {
            int num = q.size();
            Long sum = 0L;
            for (int i = 0; i < num; i++) {
                TreeNode tmp = q.poll();
                sum += tmp.val;
                if (tmp.left != null)
                    q.offer(tmp.left);
                if (tmp.right != null)
                    q.offer(tmp.right);

            }
            list.add(sum);

        }
    }
}
