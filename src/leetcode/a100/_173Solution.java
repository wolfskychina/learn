package leetcode.a100;

import java.util.Stack;

import leetcode.util.TreeNode;

/**
 * 实现bst的中序遍历迭代器
 * {bst}
 */
public class _173Solution {

    class BSTIterator {

        private final Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();

            // Traversal cur node's right branch
            TreeNode cur = node.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            return node.val;
        }
    }
}
