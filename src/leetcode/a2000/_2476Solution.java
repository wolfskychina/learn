package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

/**
 * bst中返回距离目标节点最近的左右两个节点
 * {bst},{binary search}
 */
public class _2476Solution {

    TreeNode min = null;
    TreeNode max = null;

    /**
     * 中序遍历的方式，在bst是单向链表的情况下会超时
     * 
     * @param root
     * @param queries
     * @return
     */
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        List<List<Integer>> res = new ArrayList<>();
        for (int q : queries) {
            min = null;
            max = null;
            List<Integer> tmp = new ArrayList<>();
            find(root, q);
            int l = 0;
            int r = 0;
            int m = min == null ? -1 : min.val;
            int n = max == null ? -1 : max.val;
            if (min == null) {
                l = max.val;
                r = -1;
            } else if (min.val == q) {
                l = q;
                r = q;
            } else if (max == null) {
                l = -1;
                r = min.val;

            } else {
                l = max.val;
                r = min.val;
            }
            tmp.add(l);
            tmp.add(r);
            res.add(tmp);

        }

        return res;
    }

    private void find(TreeNode p, int q) {

        if (min != null)
            return;
        if (p.left != null)
            find(p.left, q);
        if (p.val < q)
            max = p;
        // 设定遍历到第一个大于等于q的位置
        // 的终止条件要注意，不判断min是否是null的话
        // 会继续往回递归
        if (min == null && p.val >= q) {
            min = p;
            return;
        }

        if (min == null && p.right != null)
            find(p.right, q);
    }

    /**
     * 转成有序列表之后使用二分查找更快
     * 
     * @param root
     * @param queries
     * @return
     */
    public List<List<Integer>> closestNodes1(TreeNode root, List<Integer> queries) {

        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        int[] a = new int[list.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int q : queries) {
            int l = 0;
            int r = a.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (a[mid] <= q) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            if (l >= 1 && a[l - 1] == q) {
                l = q;
                r = q;
            } else if (l == 0) {
                l = -1;
                r = a[0];
            } else if (l == a.length) {
                l = a[a.length - 1];
                r = -1;
            } else {
                r = a[l];
                l = a[l - 1];
            }

            res.add(List.of(l, r));
        }
        return res;
    }

    private void traverse(TreeNode p, List<Integer> list) {

        if (p.left != null)
            traverse(p.left, list);
        list.add(p.val);
        if (p.right != null)
            traverse(p.right, list);
    }
}
