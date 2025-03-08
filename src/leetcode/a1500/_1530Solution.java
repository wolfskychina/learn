package leetcode.a1500;

import leetcode.util.TreeNode;

/**
 * 好叶子节点对的数量
 * 是指最小距离小于distance的叶子节点对
 * {binary tree},{classic}
 */
public class _1530Solution {

    /**
     * 思维很巧妙，每次只考虑以当前节点为最短路径中最顶端节点的叶子节点对的数量
     * 采用后根遍历的方式，遍历当前节点时左右子树中叶节点的距离信息已经存在
     * 
     * @param root
     * @param distance
     * @return
     */
    public int countPairs(TreeNode root, int distance) {
        this.targetDis = distance;
        dfs(root);
        return ans;
    }

    int ans;
    int targetDis;

    // 递归返回值含义：返回root节点下到所有叶子节点的距离的叶子节点个数
    // res[1] 表示root到叶子节点距离为1的个数，res[2] 表示root到叶子节点距离为2的个数....
    public int[] dfs(TreeNode root) {
        // 每个下标表示一个距离，下标0不使用，下标1表示root节点到叶子节点的距离为1的叶子节点个数
        // 注意：由于是计算两个叶子节点的距离小于distance的个数，因此到root节点距离超过distance的叶子节点个数是可以不计算的
        int[] res = new int[targetDis + 1];
        if (root == null)
            return res;
        if (root.left == null && root.right == null) {
            // 叶子节点，距离为1的次数+1
            res[1]++;
            return res;
        }
        int[] leftDis = dfs(root.left);
        int[] rightDis = dfs(root.right);
        // 假设下标i=3，表示左子树到叶子节点的距离为3，当 targetDis = 7，那么右子树到另一个叶子距离，只能是1~4
        for (int i = 1; i < targetDis + 1; i++) {
            if (leftDis[i] > 0) {
                for (int j = 1; j <= targetDis - i; j++) {
                    ans += leftDis[i] * rightDis[j]; // 节点对数
                }
            }
        }
        // 合并leftDis与rightDis，并加1
        // 牢记：递归函数返回值的含义，是root到所有叶子节点的高度
        // 假设root节点到叶子节点的距离为3，那么root节点的左右子树到叶子节点的距离就是2，因此返回值res[3] = leftDis[2] +
        // rightDis[2]
        for (int i = 1; i < targetDis + 1; i++) {
            res[i] += leftDis[i - 1] + rightDis[i - 1];
        }
        return res;
    }
}
