package leetcode.a1400;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.narray.Node;

/**
 * 克隆N叉树
 * {n-array tree},{easy}
 */
public class _1490Solution {

    /**
     * 类似于深拷贝图的题
     * @param root
     * @return
     */
    public Node cloneTree(Node root) {

        if (root == null)
            return null;

        Node p = new Node(root.val);

        List<Node> list = new ArrayList<>();
        for (Node pp : root.children) {
            list.add(cloneTree(pp));
        }
        p.children = list;
        return p;

    }

}
