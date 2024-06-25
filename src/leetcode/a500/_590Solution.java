package leetcode.a500;

import java.util.LinkedList;
import java.util.List;

import leetcode.util.narray.Node;

/**
 * N-树后根遍历
 * {tree},{easy}
 */
public class _590Solution {

    List<Integer> res = new LinkedList<>();

    public List<Integer> postorder(Node root) {
        if (root == null)
            return res;

        List<Node> tmp = root.children;

        for (Node n : tmp) {

            postorder(n);
        }

        res.add(root.val);

        return res;
    }
}
