package leetcode.a600;

import leetcode.util.TreeNode;
/**
 * 将bst瘦身成值的区间为[low,high]的新bst
 * 注意有可能根节点会被trim掉
 * {bst}
 */
public class _669Solution {

    boolean needTrim = true;

    /**
     * 循环逐个节点的比较，直到所有节点符合要求，循环终止
     * 为了处理根节点被删除的情况，采用了dummy节点指向根节点
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null)
            return root;

        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;

        while (needTrim) {
            needTrim = false;
            trimOnce(dummy, low, high);
        }

        return dummy.left;

    }

    private void trimOnce(TreeNode p, int low, int high) {

        if (p == null)
            return;

        if (p.left != null && (p.left.val < low || p.left.val > high)) {
            needTrim = true;
            if (p.left.left == null) {
                p.left = p.left.right;
            } else if (p.left.right == null) {
                p.left = p.left.left;
            } else {
                TreeNode pp = p.left.right;
                while (pp.left != null)
                    pp = pp.left;
                pp.left = p.left.left;
                p.left.left = null;
                p.left = p.left.right;
            }
        } else if (p.right != null && (p.right.val < low || p.right.val > high)) {
            needTrim = true;
            if (p.right.left == null) {
                p.right = p.right.right;
            } else if (p.right.right == null) {
                p.right = p.right.left;
            } else {
                TreeNode pp = p.right.right;
                while (pp.left != null)
                    pp = pp.left;
                pp.left = p.right.left;
                p.right.left = null;
                p.right = p.right.right;
            }
        } else {

            trimOnce(p.left, low, high);
            trimOnce(p.right, low, high);
        }
    }

    /**
     * 更简洁的递归的方法
     * 二叉树的递归中隐含着父节点对子节点的指向
     * {TODO}
     */
    public TreeNode trimBST1(TreeNode root, int low, int high) {
        if(root == null) return null;
        // 当前节点和左子树均在范围之外，直接返回右子树的递归调用结果
        if(root.val <low) return trimBST(root.right,low,high);
        // 同理返回左子树的递归调用结果
        if(root.val>high) return trimBST(root.left,low,high);

        // 节点在范围内，该节点保留，递归调用左右子节点,更新左右子节点的指向
        TreeNode left = trimBST(root.left,low,high);
        TreeNode right = trimBST(root.right,low,high);
        root.left = left;
        root.right = right;
        return root;
    }   
}
