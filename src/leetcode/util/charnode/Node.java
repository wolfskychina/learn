package leetcode.util.charnode;

public class Node {

    public char val;
    public Node left;
    public Node right;

    public Node() {
        this.val = ' ';
    }

    public Node(char val) {
        this.val = val;
    }

    Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;

    }

}
