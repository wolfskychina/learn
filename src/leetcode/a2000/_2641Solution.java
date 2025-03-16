package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

/**
 * 二叉树的堂兄弟节点
 * 把每个节点的值改成堂兄弟节点值的和
 * {binary tree}
 */
public class _2641Solution {

    /**
     * 层次遍历，修改下一层的节点值
     * @param root
     * @return
     */
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        List<TreeNode> q = List.of(root);
        while (!q.isEmpty()) {
            List<TreeNode> tmp = q;
            q = new ArrayList<>();

            // 计算下一层的节点值之和
            int nextLevelSum = 0;
            for (TreeNode node : tmp) {
                if (node.left != null) {
                    q.add(node.left);
                    nextLevelSum += node.left.val;
                }
                if (node.right != null) {
                    q.add(node.right);
                    nextLevelSum += node.right.val;
                }
            }

            // 再次遍历，更新下一层的节点值
            for (TreeNode node : tmp) {
                int childrenSum = (node.left != null ? node.left.val : 0) +
                        (node.right != null ? node.right.val : 0);
                if (node.left != null)
                    node.left.val = nextLevelSum - childrenSum;
                if (node.right != null)
                    node.right.val = nextLevelSum - childrenSum;
            }
        }
        return root;
    }
}
