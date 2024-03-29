package leetcode.a0;

import java.util.Stack;

import leetcode.util.TreeNode;

/**
 * 判断一个bst是否合法
 * {bst}
 */
public class _98Solution {

    /**
     * 中序遍历的解法
     * 
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int last = 0;
        boolean first = true;

        while (p != null || !stack.empty()) {

            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            if (first) {
                first = false;
            } else if (last >= p.val) {
                return false;
            }

            last = p.val;
            p = p.right;

        }

        return true;

    }

    /**
     * 递归的解法
     * 
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        if (root.val >= maxVal || root.val <= minVal)
            return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
