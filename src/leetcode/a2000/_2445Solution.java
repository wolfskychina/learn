package leetcode.a2000;

/**
 * 在对二叉树的一些子树进行值翻转之后，值为1的节点数
 * 用数组表示的二叉树
 * {binary tree}
 */
public class _2445Solution {

    /**
     * 对queries优化，对于相同节点的偶数次访问可以抵消
     * @param n
     * @param queries
     * @return
     */
    public int numberOfNodes(int n, int[] queries) {

        boolean node[] = new boolean[n + 1];

        int count[] = new int[n + 1];
        for (int i : queries) {
            count[i]++;
        }
        for (int i : queries) {
            count[i] %= 2;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == 0)
                continue;
            deal(i, n, node);
        }
        int res = 0;
        for (int i = 1; i < node.length; i++) {
            if (node[i]) {
                res++;
            }
        }
        return res;

    }

    private void deal(int i, int n, boolean[] node) {

        node[i] = !node[i];
        if (i * 2 <= n) {
            deal(i * 2, n, node);
        }
        if (i * 2 + 1 <= n)
            deal(i * 2 + 1, n, node);
    }
}
