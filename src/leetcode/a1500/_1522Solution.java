package leetcode.a1500;

import java.util.List;

import leetcode.util.narray.Node;

/**
 * N叉树的直径
 * N叉树中路径的最大长度，不一定经过root节点
 * {n-array tree}
 */
public class _1522Solution {

    int max = 0;

    public int diameter(Node root) {

        visit(root);

        return max;

    }

    private int visit(Node p) {

        if (p == null)
            return 0;

        List<Node> list = p.children;
        int l1 = 0;
        int l2 = 0;

        for (Node pp : list) {

            int len = visit(pp);
            if (len >= l1) {
                l2 = l1;
                l1 = len;
            } else if (len > l2) {
                l2 = len;
            }
        }

        max = Math.max(max, l1 + l2);

        return l1 + 1;
    }

}
