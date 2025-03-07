package leetcode.a2000;

import leetcode.util.TreeNode;

/**
 * 统计节点值等于其子树平均值的节点数
 * 这里的子树包括节点本身
 * 平均值为整数除法
 * {binary tree}
 */
public class _2265Solution {

    private class Stuc {
        int num = 0;
        int sum = 0;

        public Stuc(int num, int sum) {
            this.num = num;
            this.sum = sum;
        }
    }

    int res = 0;

    public int averageOfSubtree(TreeNode root) {

        dfs(root);
        return res;
    }

    private Stuc dfs(TreeNode p) {

        if (p == null)
            return null;
        Stuc r1 = dfs(p.left);
        Stuc r2 = dfs(p.right);
        if (p.val == ((r1 == null ? 0 : r1.sum) + (r2 == null ? 0 : r2.sum) + p.val)
                / ((r1 == null ? 0 : r1.num) + (r2 == null ? 0 : r2.num) + 1)) {
            res++;
        }
        return new Stuc((r1 == null ? 0 : r1.num) + (r2 == null ? 0 : r2.num) + 1,
                (r1 == null ? 0 : r1.sum) + (r2 == null ? 0 : r2.sum) + p.val);
    }

    private int cnt;

    private int ans;

    public int averageOfSubtree1(TreeNode root) {
        dfs1(root);
        return ans;
    }

    /**
     * 采用后根遍历的方式，当前节点的子树的节点数量已经统计完
     * TODO 巧妙思想，后根遍历的性质，获得子树的节点数量
     * @param root
     * @return
     */
    private int dfs1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int cur = cnt;
        cnt++;
        int left = dfs1(root.left);
        int right = dfs1(root.right);
        int sum = left + right + root.val;
        if (sum / (cnt - cur) == root.val) {
            ans++;
        }
        return sum;
    }
}
