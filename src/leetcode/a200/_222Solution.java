package leetcode.a200;

import leetcode.util.TreeNode;

/**
 * 求一个完全二叉树的节点数
 * {binary tree},{classic}
 * 
 */
public class _222Solution {

    /**
     * 可以根据子树的高度差来定位
     * 是真正的统计所有的节点个数
     * 
     * @return
     */
    public int countNodes(TreeNode root) {
        int nodes = 0, h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                // 说明左侧是满的
                nodes += 1 << h;
                // 右侧不满，需要在右侧继续迭代
                root = root.right;
            } else {
                nodes += 1 << h - 1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }

    /**
     * 通往左子树的最大高度
     * 
     * @param root
     * @return
     */
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    /**
     * 这个解法最清晰直观 
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }

    /**
     * 开始被示例给误导，以为节点的val值是按照节点顺序编号的
     * 但是实际的测试用例里面，出现了节点的val是随机值的情况
     * 自己的算法需要依赖节点的val值进行判断
     * 
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
        TreeNode p = new TreeNode(2);
        root.left = p;
        System.out.println(so.countNodes(root));

    }

}
