package leetcode.a600;

import leetcode.util.TreeNode;
/**
 * 判断能否通过去掉二叉树的一条链接，使得形成的两颗二叉树的和相同？
 * {binary tree}
 */
public class _663Solution {

    boolean equal = false;
    int sum = 0;

    /**
     * 求树的所有节点和，和任意一个子树的节点和
     * 如果有一个子树的节点和恰好是所有节点和的一半
     * 那么有符合要求的解
     * @param root
     * @return
     */
    public boolean checkEqualTree(TreeNode root) {

        sum = calSum(root);

        // 注意求子树的和的时候避免计算根节点，如果和为零的话会有错误的结果
        calSubSum(root.left);
        calSubSum(root.right);

        return equal;

    }

    private int calSubSum(TreeNode p) {
        if (equal)
            return 0;
        if (p == null)
            return 0;

        int s = p.val + calSubSum(p.left) + calSubSum(p.right);
        if (s * 2 == sum)
            equal = true;
        return s;
    }

    private int calSum(TreeNode p) {

        if (p == null)
            return 0;

        return p.val + calSum(p.left) + calSum(p.right);
    }

    public static void main(String[] args) {
        _663Solution so = new _663Solution();
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(10);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(3);
        root.left = n1;
        root.right = n2;
        n2.left = n5;
        n2.right = n6;
        so.checkEqualTree(root);
    }
}
