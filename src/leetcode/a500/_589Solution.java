package leetcode.a500;

import java.util.LinkedList;
import java.util.List;

import leetcode.util.narray.Node;

/**
 * N-树先根遍历
 */
public class _589Solution {
    List<Integer> res = new LinkedList<>();

    public List<Integer> preorder(Node root) {

        if (root == null)
            return res;

        res.add(root.val);

        List<Node> tmp = root.children;

        for (Node n : tmp) {

            preorder(n);
        }

        return res;

    }
}
