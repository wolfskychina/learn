package leetcode.a800;

import java.util.ArrayList;
import java.util.List;
import leetcode.util.TreeNode;

/**
 * 将bst改造成一棵所有节点只有右节点的链树
 * {bst}
 */
public class _897Solution {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;
        for (int value : res) {
            currNode.right = new TreeNode(value);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }

    public void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

    /**
     * 全局临时节点
     */
    private TreeNode resNode;

    /**
     * 在中序遍历的同时改变指向，需要一个全局临时节点记录上一个访问的节点
     * 即比当前节点小的上一个节点，让这个全局节点的右子树指向当前节点
     * {TODO}
     * 
     * @param root
     * @return
     */
    public TreeNode increasingBST1(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorder(root);
        return dummyNode.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);

        // 在中序遍历的过程中修改节点指向
        // 临时节点的左右子树在递归调用时已经赋值
        // 所以在这里改变临时节点的左右子树，并不会影响
        // 返回后的递归
        // 临时节点是在中序遍历中上一个被访问的节点
        resNode.right = node;
        node.left = null;
        resNode = node;

        inorder(node.right);
    }

}
