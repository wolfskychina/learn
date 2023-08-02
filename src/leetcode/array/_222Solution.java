package leetcode.array;

import leetcode.util.TreeNode;

/**
 * 求一个完全二叉树的节点数
 * 
 */
public class _222Solution {

    /**
     * 可以根据子树的高度差来定位
     * 是真正的统计所有的节点个数
     * @return
     */
    public int countNodes(TreeNode root) {
        int nodes = 0, h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h-1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }

    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    
    /**
     * 开始被示例给误导，以为节点的val值是按照节点顺序编号的
     * 但是实际的测试用例里面，出现了节点的val是随机值的情况
     * 自己的算法需要依赖节点的val值进行判断 
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root) {

        if (root == null)
            return 0;
        TreeNode p = root;

        int h = 0;
        while (p != null) {
            h++;
            p = p.left;
        }

        int l = (int) Math.pow(2, h - 1);
        p = root;
        TreeNode lp = p;
        while (p != null && p.val < l) {

            if (rightmostisnull(l, p)) {
                lp = p;
                p = p.left;
            } else {
                lp = p;
                p = p.right;
            }
        }

        if (lp.left == null)
            return lp.val * 2 - 1;
        if (lp.right == null)
            return lp.val * 2;
        return lp.val * 2 + 1;

    }

    private boolean rightmostisnull(int l, TreeNode p) {

        if (p.left == null)
            return true;
        p = p.left;
        while (p.right != null) {
            p = p.right;
        }
        if (p.val < l)
            return true;

        return false;
    }

    public static void main(String[] args) {

        _222Solution so = new _222Solution();
        TreeNode root = new TreeNode(1);
        System.out.println(so.countNodes(root));

    }

}
