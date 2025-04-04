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

    /**
     * TODO 关键点，二叉查找树中没有重复元素
     * 类似二分查找的思路，往不同的方向进行查找
     * 但是运行速度比较慢
     * {binary search}
     * @param root1
     * @param root2
     * @param target
     * @return
     */
    public boolean twoSumBSTs1(TreeNode root1, TreeNode root2, int target) {

        int sum = root1.val+root2.val;
        if(sum==target) return true;
        if(sum>target) return (root1.left!=null?twoSumBSTs1(root1.left, root2, target):false)||
                            (root2.left!=null?twoSumBSTs1(root1, root2.left, target):false);
        return (root1.right!=null?twoSumBSTs1(root1.right, root2, target):false)||
        (root2.right!=null?twoSumBSTs1(root1, root2.right, target):false);
    }

    /**
     * 同样是二分，为什么这个这么快
     * @param root1
     * @param root2
     * @param target
     * @return
     */
    public boolean twoSumBSTs2(TreeNode root1, TreeNode root2, int target) {
        if (root2 == null) {
            return false;
        }
        int newTarget = target - root2.val;
        TreeNode curr = root1;
        while (curr != null) {
            if (curr.val == newTarget) {
                return true;
            }
            if (curr.val > newTarget) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return twoSumBSTs(root1, root2.left, target) || twoSumBSTs(root1, root2.right, target);
    }
}
