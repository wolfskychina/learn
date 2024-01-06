package leetcode.a800;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;
/**
 * 二叉树中所有到目标节点距离为k的节点集合
 */
public class _863Solution {

    private List<Integer> res = new ArrayList<>();

    /**
     * target下方的节点和经过target上方的节点分开寻找
     * {binary tree}
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        if (k == 0) {
            res.add(target.val);
            return res;
        }

        search(root, target, k);

        return res;

    }

    private int search(TreeNode p, TreeNode target, int k) {

        if (p == target) {
            searchdown(p, k);
            return 0;
        }
        if (p.left != null) {
            int lreturn = search(p.left, target, k);

            if (lreturn >= 0) {

                if (k > lreturn + 1 && p.right != null) {
                    searchdown(p.right, k - lreturn - 2);
                } else if (k == lreturn + 1) {
                    res.add(p.val);
                }
                return lreturn + 1;
            }
        }
        if (p.right != null) {
            int rreturn = search(p.right, target, k);
            if (rreturn >= 0) {
                if (k > rreturn + 1 && p.left != null) {
                    searchdown(p.left, k - rreturn - 2);
                } else if (k == rreturn + 1) {
                    res.add(p.val);
                }

                return rreturn + 1;
            }

        }

        return -1;

    }

    private void searchdown(TreeNode p, int remain) {

        if (remain == 0) {
            res.add(p.val);
            return;
        }
        if (p.left != null)
            searchdown(p.left, remain - 1);
        if (p.right != null)
            searchdown(p.right, remain - 1);
    }
}
