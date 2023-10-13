package leetcode.a400;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.narray.Node;

/**
 * N叉树的层次遍历
 */
public class _429Solution {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new LinkedList<>();

        if (root == null)
            return res;

        Queue<Node> q = new LinkedList<>();
        int num = 1;
        q.offer(root);

        while (!q.isEmpty()) {

            List<Integer> tmpq = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                Node n = q.poll();
                tmpq.add(n.val);
                if (n.children != null && n.children.size() != 0) {
                    for (Node nn : n.children) {
                        q.offer(nn);
                    }

                }

            }

            res.add(tmpq);
            num = q.size();

        }

        return res;

    }
}
