package leetcode.a1000;

import leetcode.util.TreeNode;

/**
 * 在受到污染的二叉树中查找目标值
 * {binary tree}
 */
public class _1261Solution {

    /**
     * 使用TreeNode保存每个节点空间消耗大，速度慢
     * 查找速度ologn
     */
    class FindElements {

        private TreeNode root;

        public FindElements(TreeNode root) {
            this.root = root;
            formTree(root, 0);
        }

        private void formTree(TreeNode p, int val) {

            p.val = val;
            if (p.left != null)
                formTree(p.left, 2 * val + 1);
            if (p.right != null)
                formTree(p.right, 2 * val + 2);

        }

        public boolean find(int target) {

            return find(root, target);

        }

        private boolean find(TreeNode p, int tar) {

            if (p == null)
                return false;

            if (p.val == tar) {
                return true;
            }

            return (p.left != null && find(p.left, tar)) || (p.right != null && find(p.right, tar));

        }
    }

    /**
     * 把所有存在的val都存到一个数组中，查询复杂度降低为o1 
     */
    class FindElements1 {

        private final boolean[] nodes;
    
        FindElements1(TreeNode root) {
            int height = getHeight(root);
            this.nodes = new boolean[2 << height];
            dfs(root, 0);
        }
    
        int getHeight(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    
        void dfs(TreeNode node, int val) {
            nodes[val] = true;
            if (node.left != null) {
                dfs(node.left, (val << 1) + 1);
            }
            if (node.right != null) {
                dfs(node.right, (val + 1) << 1);
            }
        }
    
        boolean find(int target) {
            return target >= 0 && target < nodes.length && nodes[target];
        }
    }
}
