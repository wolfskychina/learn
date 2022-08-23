package stuc.bst;

/**
 * A node in a Binary Search Tree
 */
public class Node<T> {


    // Children Nodes
    private Node<T> left;
    private Node<T> right;

    // Parent Node
    private Node<T> parent;

    // Value, can be any kind
    private T value;

    public Node(Node<T> left,Node<T> right,Node<T> parent,T value) {

        this.left = left;
        this.right = right;
        this.parent = parent;
        this.value = value;

    }


    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
