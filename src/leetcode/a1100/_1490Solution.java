package leetcode.a1100;

import java.util.ArrayList;
import java.util.List;

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

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
