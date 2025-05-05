package leetcode.a1400;

import leetcode.util.TreeNode;

/**
 * 二叉树自顶到底的所有路径中，满足路径上值的任意排序满足回文的路径数量
 * 节点取值范围为1-9
 * {binary tree},{bit manuplation}
 */
public class _1457Solution {

    int count[] = new int[10];
    int res = 0;

    /**
     * 直接做法，比较慢
     * @param root
     * @return
     */
    public int pseudoPalindromicPaths(TreeNode root) {

        find(root);
        return res;
    }

    private void find(TreeNode p) {

        count[p.val]++;
        if (p.left == null && p.right == null && valid()) {
            res++;
            count[p.val]--;
            return;
        }

        if (p.left != null)
            find(p.left);
        if (p.right != null)
            find(p.right);
        count[p.val]--;
    }

    private boolean valid() {
        int countOdd = 0;
        for (int i = 1; i < 10; i++) {
            if (count[i] % 2 == 1)
                countOdd++;
            if (countOdd == 2)
                return false;
        }
        return true;
    }

    int path = 0, pathCount = 0;

    /**
     * 非常巧妙的使用了位运算的性质
     * 用1表示出现了奇数次，用0表示出现了偶数次
     * 数字实际出现的次数没有用，只需要看出现奇数次的数字不超过一种即可
     * @param root
     * @return
     */
    public int pseudoPalindromicPaths1(TreeNode root) {
        traversal(root);
        return pathCount;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        // 把 第root.val位 做异或操作; 1代表奇数次 0代表偶数次
        int curVal = 1 << root.val;
        path ^= curVal;
        if (root.left == null && root.right == null) {
            // 巧妙判断奇数次元素出现的次数
            // 只有奇数次元素有0个或者1个的时候结果为0
            if ((path & (path - 1)) == 0) {
                pathCount++;
            }
            path ^= curVal;
            return;
        }
        traversal(root.left);
        traversal(root.right);
        path ^= curVal;
    }
}
