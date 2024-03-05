package leetcode.a100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import leetcode.util.TreeNode;

/**
 * TODO
 * 根据中根和后跟顺序构建二叉树
 * 跟上题原理一样
 * {binary tree}
 */
public class _106Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
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

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        
        for(int i=0;i<inorder.length;i++){
            hash.put(inorder[i], i);
        }
        
        return helper(postorder.length-1,0, inorder.length-1,inorder, postorder,hash);
    }
    
    private TreeNode helper(int rootIdx, int leftInOrder, int rightInOrder, int[] inorder, int[] postorder, Map<Integer, Integer> hash){
        
        if(rootIdx<0 || leftInOrder>rightInOrder) return null;
        
        TreeNode root =new TreeNode(postorder[rootIdx]);
        // 当前根在中根序列中的位置
        int next = hash.get(postorder[rootIdx]);
        
        // 左子树的根的位置是当前根的位置跳过右子树节点数量的前一个位置
        root.left  = helper( rootIdx- (rightInOrder-next)-1, leftInOrder ,next-1 , inorder,postorder,hash);
        root.right = helper( rootIdx-1,next +1 , rightInOrder, inorder,postorder,hash);
        
        return root;
    }

    public static void main(String[] args) {

        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };

        _106Solution so = new _106Solution();
        so.buildTree(inorder, postorder);

    }

}
