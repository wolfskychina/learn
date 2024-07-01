package leetcode.a600;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;
/**
 * 以二维list的形式格式化输出一颗二叉树
 * {binary tree}
 */
public class _655Solution {

    /**
     * 关键是根据树的高度计算出所需的矩阵的长宽
     * 然后计算出根节点的坐标
     * 然后根据根节点的坐标，分别计算左右子节点的坐标
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {

        int h = calHeight(root, 0, 0);
        int m = h + 1;
        int n = (int) Math.pow(2, m) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            res.add(list);
        }
        addNode(res, root, 0, (n - 1) / 2, h);
        return res;

    }

    private void addNode(List<List<String>> res, TreeNode root, int i, int j, int h) {
        if (root == null)
            return;
        res.get(i).set(j, String.valueOf(root.val));
        if (root.left != null)
            // c-2height-r-1
            addNode(res, root.left, i + 1, j - (int) Math.pow(2, h - j - 1), h);
        if (root.right != null)
            addNode(res, root.right, i + 1, j + (int) Math.pow(2, h - j - 1), h);

    }

    private int calHeight(TreeNode root, int i, int max) {
        if (root == null)
            return 0;
        max = Math.max(max, i);
        calHeight(root.left, i + 1, max);
        calHeight(root.right, i + 1, max);
        return max;
    }
}
