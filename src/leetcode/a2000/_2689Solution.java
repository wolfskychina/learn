package leetcode.a2000;
/**
 * 从 Rope 树中提取第 K 个字符
 * {binary tree}
 */
public class _2689Solution {

    class RopeTreeNode {
        int len;
        String val;
        RopeTreeNode left;
        RopeTreeNode right;

        RopeTreeNode() {
        }

        RopeTreeNode(String val) {
            this.len = 0;
            this.val = val;
        }

        RopeTreeNode(int len) {
            this.len = len;
            this.val = "";
        }

        RopeTreeNode(int len, RopeTreeNode left, RopeTreeNode right) {
            this.len = len;
            this.val = "";
            this.left = left;
            this.right = right;
        }
    }

    public char getKthCharacter(RopeTreeNode root, int k) {
        if (root.len == 0) {
            return root.val.charAt(k - 1);
        }
        RopeTreeNode left = root.left, right = root.right;
        int leftLen = left != null ? Math.max(left.len, left.val.length()) : 0;
        if (k <= leftLen) {
            return getKthCharacter(left, k);
        } else {
            return getKthCharacter(right, k - leftLen);
        }
    }

}
