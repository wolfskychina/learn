package leetcode.a800;

import leetcode.util.TreeNode;
/**
 * 二叉树的路径和
 * {binary tree}
 */
public class _1022Solution {

    private static int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        sum=0;
        traverse(root, "");
        return sum;
    }

    private void traverse(TreeNode p, String prefix) {

        if (p.left == null && p.right == null) {
            sum += Integer.parseInt(prefix + p.val, 2);
            return;
        }

        if (p.left != null)
            traverse(p.left, prefix + p.val);
        if (p.right != null)
            traverse(p.right, prefix + p.val);
        return;
    }

    public static void main(String[] args){
        _1022Solution so = new _1022Solution();
        TreeNode p = new TreeNode(0);
        so.sumRootToLeaf(p);
    }

    /**
     * 直接将上层的数值*2，避免对字符串拼接
     * @param root
     * @return
     */
    public int sumRootToLeaf1(TreeNode root) {
        visit(root, 0);
        return sum;
    }

    public void visit(TreeNode root, int parentSum){
        if(root == null)
            return;
        
        int temp = parentSum * 2 + root.val;
        if(root.left == null && root.right == null){
            sum += temp;
            return ;
        }

        visit(root.left, temp);
        visit(root.right, temp);
    }
}
