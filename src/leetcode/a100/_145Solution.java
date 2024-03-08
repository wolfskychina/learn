package leetcode.a100;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import leetcode.util.TreeNode;

/**
 * 后根遍历二叉树
 * {binary tree}
 */
public class _145Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        // 首先如果要插入元素操作，链表比数组肯定快
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {

            TreeNode curr = stack.pop();
            list.add(0,curr.val);

            if(curr.left!=null) {
              stack.push(curr.left);
            }
            if(curr.right!=null) {
               stack.push(curr.right);
            }
        }
        return list;
    }
    
    


}
