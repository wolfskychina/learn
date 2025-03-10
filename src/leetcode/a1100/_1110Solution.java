package leetcode.a1100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leetcode.util.TreeNode;

/**
 * 删除所有目标点，返回剩下的森林
 * {binary tree}
 */
public class _1110Solution {

    List<TreeNode> list;

    /**
     * 返回时进行操作
     * @param root
     * @param to_delete
     * @return
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        list = new ArrayList<>();
        if (!dell(root, set)) {
            list.add(root);
        }
        return list;

    }

    private boolean dell(TreeNode p, Set<Integer> set) {

        if (p == null)
            return false;
        if (dell(p.left, set)) {
            p.left = null;
        }
        if (dell(p.right, set)) {
            p.right = null;
        }

        if (set.contains(p.val)) {
            if (p.left != null)
                list.add(p.left);
            if (p.right != null)
                list.add(p.right);
            return true;
        } else
            return false;

    }
}
