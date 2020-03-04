package leetcode.array;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _106Solution {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int ip = inorder.length - 1;
        int pp = postorder.length - 1;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[pp]);
        stack.push(root);
        pp--;

        while (pp >= 0) {
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                prev = stack.pop();
                ip--;
            }
            TreeNode newNode = new TreeNode(postorder[pp]);
            if (prev != null) {
                prev.left = newNode;
            } else if (!stack.isEmpty()) {
                TreeNode currTop = stack.peek();
                currTop.right = newNode;
            }
            stack.push(newNode);
            prev = null;
            pp--;
        }

        return root;
    }

    public static void main(String[] args){

        int[] inorder = {9, 3, 15, 20,7};
        int[] postorder = {9, 15, 7, 20, 3};

        _106Solution so = new _106Solution();
        so.buildTree(inorder, postorder);

    }


}
