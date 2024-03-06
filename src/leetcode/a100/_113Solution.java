package leetcode.a100;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

/**
 * 输出所有节点值的和为sum的路径
 * {binary tree}
 */
public class _113Solution {

    private List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null)
            return res;

        findSum(root, 0, sum, new ArrayList<Integer>());

        return res;
    }

    private void findSum(TreeNode p, int sum2, int sum, List<Integer> list) {
        if (p == null)
            return;

        // 确保p是一个叶子节点的条件，左右子树都为null，p本身为null不行
        if (p.left == null && p.right == null && sum2 + p.val == sum) {
            list.add(p.val);
            res.add(new ArrayList<Integer>(list));
            // 一开始落了这一部，输出就错了，list会影响其他尚未求解分支
            // list是引用传递
            list.remove(list.size() - 1);
            return;
        }
        list.add(p.val);
        findSum(p.left, sum2 + p.val, sum, list);
        findSum(p.right, sum2 + p.val, sum, list);
        list.remove(list.size() - 1);
    }
}
