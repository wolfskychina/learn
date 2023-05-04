package stuc.bst;

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

        while(!s.isEmpty()){
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






}