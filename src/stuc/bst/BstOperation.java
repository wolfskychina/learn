package stuc.bst;

import java.util.Stack;

/**
 * Binary Search Tree Operations
 */
public class BstOperation {

    /**
     * bst的中根遍历可以按大小输出树中的元素
     * @param x
     */
    /**
     * Inorder Tree Walk - Recursive version
     * 
     * @param Node x
     */
    public static <T> void inorderTreeWalk1(Node<T> x) {

        if (x != null) {

            inorderTreeWalk1(x.getLeft());

            System.out.println(x.getValue());

            inorderTreeWalk1(x.getRight());
        }

    }

    /**
     * Inorder Tree Walk - Non-recursive version
     * 
     * @param Node x
     */
    public static <T> void inorderTreeWalk2(Node<T> x) {

        Stack<Node<T>> s = new Stack<>();

        while (x != null || !s.isEmpty()) {

            while (x != null) { // 入栈的操作是左子树迭代到底
                s.push(x);
                x = x.getLeft();
            }

            if (!s.empty()) { // 出栈的操作是每次一个
                x = s.pop();
                System.out.println(x.getValue());
                x = x.getRight();
            }
        }
    }

    /**
     * Inorder Tree Walk - a better non-recur version
     * 
     * @param x
     */
    public static <T> void inorderTreeWalk3(Node<T> x) {

        Stack<Node<T>> s = new Stack<>();

        while (x != null || !s.isEmpty()) {

            if (x != null) {
                s.push(x);
                x = x.getLeft();

            } else {
                x = s.pop();
                System.out.println(x.getValue());
                x = x.getRight();
            }
        }
    }


    public static void main(String[] args) {

    }

}
