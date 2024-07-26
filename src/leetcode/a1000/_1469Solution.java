package leetcode.a1000;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

/**
 * 寻找所有的独生节点
 * {easy}
 */
public class _1469Solution {
    public List<Integer> getLonelyNodes(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        findLonelyChild(root, res);
        return res;
    }

    private void findLonelyChild(TreeNode p, List<Integer> res) {

        if (p.left == null && p.right != null) {
            res.add(p.right.val);
        }
        if (p.left != null && p.right == null) {
            res.add(p.left.val);
        }
        if (p.left != null)
            findLonelyChild(p.left, res);
        if (p.right != null)
            findLonelyChild(p.right, res);
    }
}
