package leetcode.a500;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;
/**
 * 返回二叉树每层值最大的节点的值
 * {binary tree},{easy}
 */
public class _515Solution {

    List<Integer> list = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {

        traverse(root, 0);

        return list;

    }

    private void traverse(TreeNode node, int level) {

        if (node == null)
            return;

        if (list.size() < level + 1) {
            list.add(node.val);
        } else {
            list.set(level, Math.max(list.get(level), node.val));
        }
        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }
}
