package stuc.bst;

/**
 * A node in a Binary Search Tree
 */
public class Node {



    private Node left;
    private Node right;

    private Node parent;


    private int value;

    public Node(Node left,Node right,Node parent,int value) {

        this.left = left;
        this.right = right;
        this.parent = parent;
        this.value = value;

    }


    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
