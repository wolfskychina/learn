package leetcode.a100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 深拷贝一颗邻接表表示的树
 * {graph}
 */
public class _133Solution {

    // Definition for a Node.
    class Node {

        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        Node root = new Node(node.val);
        map.put(node.val, root);
        for (Node next : node.neighbors) {

            root.neighbors.add(clone(next));
        }

        return root;

    }

    private Node clone(Node node) {

        if (map.get(node.val) == null) {

            Node newNode = new Node(node.val);
            map.put(node.val, newNode);
            for (Node next : node.neighbors) {
                newNode.neighbors.add(clone(next));
            }

            return newNode;
        } else {
            // 如果map中已经有该节点，只需要返回引用
            return map.get(node.val);
        }
    }

}
