package leetcode.a0;

import java.util.Stack;

import leetcode.util.TreeNode;

/**
 * 一个bst中，有两个节点对换了位置，破坏了bst的性质
 * 需要恢复bst的特性，但是不能改变bst的结构
 * {bst}
 */
public class _99Solution {

    public void recoverTree(TreeNode root) {

        TreeNode p = root;

        TreeNode[] p1 = { null, null };
        TreeNode[] p2 = { null, null };
        TreeNode last = null;
        int index = 0;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (p != null || !stack.empty()) {

            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();

            if (last != null) {

                if (last.val >= p.val) {
                    // found a reverse pair
                    p1[index] = last;
                    p2[index] = p;
                    index++;
                }
            }

            last = p;
            p = p.right;
        }

        if (index == 1) {
            // 恰好交换位置的节点是相邻的
            int tmp = p1[0].val;
            p1[0].val = p2[0].val;
            p2[0].val = tmp;
        } else if (index == 2) {
            // 交换位置的节点是不相邻的
            int tmp = p1[0].val;
            p1[0].val = p2[1].val;
            p2[1].val = tmp;
        }

    }

    TreeNode firstElement = null;
    TreeNode secondElement = null;
    // The reason for this initialization is to avoid null pointer exception in the
    // first comparison when prevElement has not been initialized
    TreeNode prevElement = null;

    public void recoverTree2(TreeNode root) {

        // In order traversal to find the two elements
        traverse(root);

        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {

        if (root == null)
            return;

        traverse(root.left);

        if (prevElement != null) {
            // Start of "do some business",
            // If first element has not been found, assign it to prevElement (refer to 6 in
            // the example above)
            if (firstElement == null && prevElement.val >= root.val) {
                firstElement = prevElement;
            }

            // If first element is found, assign the second element to the root (refer to 2
            // in the example above)
            if (firstElement != null && prevElement.val >= root.val) {
                secondElement = root;
            }
        }

        prevElement = root;

        // End of "do some business"
        traverse(root.right);
    }
}
