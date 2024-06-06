package leetcode.a400;

import leetcode.util.TreeNode;

/**
 * 通过修改left和right指针的指向
 * 将bst改成双向循环列表，其中left和right表示节点在顺序遍历中的前后节点
 * 要求原址操作
 * {bst}
 */
public class _426Solution {

    TreeNode first;
    TreeNode pre;

    /**
     * 中序遍历
     * 用一个全局指针指向顺序遍历中刚才访问过的节点
     * 
     * @param root
     * @return
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null)
            return null;
        helper(root);
        first.left = pre;
        pre.right = first;
        return first;
    }

    public void helper(TreeNode TreeNode) {
        if (TreeNode == null)
            return;

        // 中序遍历先访问左子树
        helper(TreeNode.left);

        // 访问当前节点
        // first若为空则赋值，first只赋值一次
        if (first == null) {
            first = TreeNode;
        }
        // pre为空则赋值
        if (pre == null) {
            pre = TreeNode;
        }
        // 否则将当前节点与pre连接，同时移动pre指向当前节点
        else {
            pre.right = TreeNode;
            TreeNode.left = pre;
            pre = TreeNode;
        }

        // 最后访问右子树
        helper(TreeNode.right);
    }

}
