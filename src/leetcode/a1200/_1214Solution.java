package leetcode.a1200;

import java.util.HashSet;
import java.util.Set;

import leetcode.util.TreeNode;

/**
 * 二叉树形式的two sum问题
 * {binary tree},{easy}
 */
public class _1214Solution {

    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {

        visit(root1, set1);
        visit(root2, set2);

        for (int i : set1) {
            if (set2.contains(target - i))
                return true;
        }
        return false;
    }

    private void visit(TreeNode p, Set<Integer> set) {

        if (p == null)
            return;
        set.add(p.val);
        visit(p.left, set);
        visit(p.right, set);
    }
}
