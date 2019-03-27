package stuc.bst;

/**
 * A node in a Binary Search Tree
 */
public class Node<T> {


    // Children Nodes
    private Node left;
    private Node right;

    // Parent Node
    private Node parent;

    // Value, can be any kind
    private T value;

    public Node(Node left,Node right,Node parent,T value) {

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

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
