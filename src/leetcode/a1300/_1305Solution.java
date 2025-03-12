package leetcode.a1300;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

/**
 * 两颗bst中的所有元素按照大小排序输出
 * {bst},{binary tree},{easy}
 */
public class _1305Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        traverse(root1, l1);
        traverse(root2, l2);
        return merge(l1, l2);

    }

    private void traverse(TreeNode p, List<Integer> list) {
        if (p == null)
            return;
        if (p.left != null)
            traverse(p.left, list);

        list.add(p.val);
        if (p.right != null)
            traverse(p.right, list);
    }

    private List<Integer> merge(List<Integer> l1, List<Integer> l2) {

        List<Integer> res = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < l1.size() && idx2 < l2.size()) {
            if (l1.get(idx1) < l2.get(idx2)) {
                res.add(l1.get(idx1));
                idx1++;
            } else {
                res.add(l2.get(idx2));
                idx2++;
            }
        }
        while (idx1 < l1.size()) {
            res.add(l1.get(idx1++));
        }
        while (idx2 < l2.size()) {
            res.add(l2.get(idx2++));
        }
        return res;
    }
}
