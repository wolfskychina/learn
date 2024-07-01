package leetcode.a600;

import leetcode.util.TreeNode;

/**
 * 构建最大二叉树
 */
public class _654Solution {

    /**
     * {binary tree}
     * 
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return construct(nums, 0, nums.length - 1);

    }

    private TreeNode construct(int[] nums, int i, int j) {
        if (i > j)
            return null;

        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int k = i; k <= j; k++) {
            if (nums[k] > max) {
                max = nums[k];
                idx = k;
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = construct(nums, i, idx - 1);
        root.right = construct(nums, idx + 1, j);
        return root;

    }

    public static void main(String[] args) {
        _654Solution so = new _654Solution();
        int[] nums = { 3, 2, 1, 6, 0, 5 };
        so.constructMaximumBinaryTree(nums);
    }
}
