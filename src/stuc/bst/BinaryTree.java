package stuc.bst;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    /**
     * First non-retrival tree walk 
     * @param Node x
     */
    public static <T> void firstTreeWalk(Node<T> x){
        if(x ==null) return ;

        Stack<Node<T>> s = new Stack<>();
        s.push(x);

        while(!s.isEmpty()){
            Node<T> node = s.pop();
            System.out.println(node.getValue());
            if(node.getRight()!=null) s.push(node.getRight());
            if(node.getLeft()!=null) s.push(node.getLeft());
        }
    }

    /**
     * middle non-retrival tree walk
     */
    public static <T>  void middleTreeWalk(Node<T> x){
        if(x== null) return ;

        Stack<Node<T>> s = new Stack<>();

        while(!s.isEmpty()||x!=null){
            if(x!=null){
                s.push(x);
                x = x.getLeft();
            }else{
                x = s.pop();
                System.out.println(x.getValue());
                x = x.getRight();
            }
        }


    }

    public static <T> List<T> postorderTraversal(Node<T> root) {
        // 首先如果要插入元素操作，链表比数组肯定快
        List<T> list = new LinkedList<>();
        if(root == null) return list;
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {

            Node<T> curr = stack.pop();
            list.add(0,curr.getValue());

            if(curr.getLeft()!=null) {
              stack.push(curr.getLeft());
            }
            if(curr.getRight()!=null) {
               stack.push(curr.getRight());
            }
        }
        return list;
    }


    /**
     * Binary Tree Level Order Traversal
     */
    public static <T> void levelOrderTraversal(Node<T> node){

        if(node == null) return ;

        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(node);

        while(!queue.isEmpty()){

            Node<T> n = queue.poll();
            System.out.println(n.getValue());
            if(n.getLeft()!=null) queue.add(n.getLeft());
            if(n.getRight()!=null) queue.add(n.getRight());

        }

               
    }






}