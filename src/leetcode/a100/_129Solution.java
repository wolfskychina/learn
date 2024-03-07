package leetcode.a100;

import leetcode.util.TreeNode;

/**
 * 求树中所有路径所代表的数字之和
 * {binary tree}
 */
public class _129Solution {
    
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    
    public int sum(TreeNode n, int s){
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }
}