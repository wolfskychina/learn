package leetcode.a1300;

import java.util.ArrayList;

import leetcode.util.TreeNode;

/**
 * 将bst变成平衡bst
 * {bst},{binary tree}
 */
public class _1382Solution {

    ArrayList<Integer> res = new ArrayList<Integer>();

    // 有序树转成有序数组
    private void travesal(TreeNode cur) {
        if (cur == null)
            return;
        travesal(cur.left);
        res.add(cur.val);
        travesal(cur.right);
    }

    // 有序数组转成平衡二叉树
    private TreeNode getTree(ArrayList<Integer> nums, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = getTree(nums, left, mid - 1);
        root.right = getTree(nums, mid + 1, right);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        travesal(root);
        return getTree(res, 0, res.size() - 1);
    }
}
