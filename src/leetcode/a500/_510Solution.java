package leetcode.a500;

public class _510Solution {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node node) {

        // 如果有右子树，那么后继节点是右子树的最小节点
        if (node.right != null) {
            Node next = node.right;
            while (next.left != null) {
                next = next.left;
            }
            return next;
        }
        // 如果没有右子树，那么是自下而上的父辈节点中第一个子节点是自己左子树的节点
        Node p = node.parent;
        if (p == null)
            return null;

        while (p != null && p.right == p) {
            p = p.parent;
        }
        return p == null ? null : p.parent;

    }
}
