package leetcode.a700;

import leetcode.util.TreeNode;
/**
 * 将一个bst拆分成两棵bst，使得一个bst中的值全部小于等于v，另一个bst中的值全部大于V
 * 返回拆分好的两棵bst的两个根
 */
public class _776Solution {

    /**
     * {bst},{recursation}
     * TODO 自下向上组装的过程
     * @param root
     * @param V
     * @return
     */
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null)
            return new TreeNode[] { null, null };
        else if (root.val <= V) {
            TreeNode[] bns = splitBST(root.right, V);
            root.right = bns[0];
            bns[0] = root;
            return bns;
        } else {
            TreeNode[] bns = splitBST(root.left, V);
            root.left = bns[1];
            bns[1] = root;
            return bns;
        }
    }

}
