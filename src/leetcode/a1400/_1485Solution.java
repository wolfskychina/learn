package leetcode.a1400;

import java.util.HashMap;
import java.util.Map;

/**
 * 克隆含随机指针的二叉树
 * {binary tree}
 */
public class _1485Solution {

    Map<Node, NodeCopy> map;

    public NodeCopy copyRandomBinaryTree(Node root) {
        map = new HashMap<>();
        NodeCopy r2 = copyTree(root);
        dealRandom(root, r2);
        return r2;
    }

    private NodeCopy copyTree(Node p) {

        if (p == null)
            return null;
        NodeCopy node = new NodeCopy(p.val);
        map.put(p, node);
        if (p.left != null)
            node.left = copyTree(p.left);
        if (p.right != null)
            node.right = copyTree(p.right);

        return node;
    }

    private void dealRandom(Node n, NodeCopy nc) {
        if (n == null)
            return;

        nc.random = map.get(n.random);
        dealRandom(n.left, nc.left);
        dealRandom(n.right, nc.right);
    }

    public class Node {
        int val;
        Node left;
        Node right;
        Node random;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right, Node random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    public class NodeCopy {
        int val;
        NodeCopy left;
        NodeCopy right;
        NodeCopy random;

        NodeCopy() {
        }

        NodeCopy(int val) {
            this.val = val;
        }

        NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }
}
