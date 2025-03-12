package leetcode.a1600;

import java.util.HashSet;
import java.util.Set;

import leetcode.util.TreeNode;

/**
 * 二叉树的最近公共祖先
 * 这次是一组节点的最近公共祖先
 * {binary tree},{lca}
 */
public class _1676Solution {

    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        res = null;
        int tar = nodes.length;
        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node);
        }

        find(root, tar, set);
        return res;

    }

    private int find(TreeNode p, int tar, Set<TreeNode> set) {
        if (res != null)
            return 0;
        if (p == null)
            return 0;
        if (p.left == null && p.right == null) {
            if (set.contains(p)) {
                if (tar == 1) {
                    res = p;
                    return 0;
                }
                return 1;
            }
            return 0;
        }
        int l = find(p.left, tar, set);
        int r = find(p.right, tar, set);
        if (l + r + (set.contains(p) ? 1 : 0) == tar) {
            res = p;
            return 0;
        } else {
            return l + r + (set.contains(p) ? 1 : 0);
        }
    }

    /**
     * 题目假设隐含了所有的目标nodes，所以只需要返回最后找到的节点
     * 或者最下层的公共节点即可
     * 代码比较简洁
     * 
     * @param root
     * @param nodes
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode[] nodes) {
        if (root == null) {
            return root;
        }

        for (TreeNode n : nodes) {
            if (root == n) {
                return root;
            }
        }

        TreeNode left = lowestCommonAncestor1(root.left, nodes);
        TreeNode right = lowestCommonAncestor1(root.right, nodes);

        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}
