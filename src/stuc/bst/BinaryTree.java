package stuc.bst;

import java.util.Stack;

public class BinaryTree {

    /**
     * First non-retrival tree walk 
     * @param Node x
     */
    public static void firstTreeWalk(Node x){
        if(x ==null) return ;

        Stack<Node> s = new Stack<>();
        s.push(x);

        while(!s.isEmpty()){
            Node node = s.pop();
            System.out.println(node.getValue());
            if(node.getLeft()!=null) s.push(node.getLeft());
            if(node.getRight()!=null) s.push(node.getRight());
        }
    }







}