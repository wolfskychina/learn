package leetcode.a500;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import leetcode.util.TreeNode;
/**
 * 寻找二叉树中所有子树的元素和的众数
 * 如果有多个众数，全部输出
 * {binary tree}
 */
public class _508Solution {

    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {

        int sum = traverse(root);
        int count = map.getOrDefault(sum, 0) + 1;
        max = Math.max(count, max);
        map.put(sum, count);

        List<Integer> list = new LinkedList<>();
        for (Entry<Integer, Integer> en : map.entrySet()) {

            if (en.getValue() == max) {
                list.add(en.getKey());
            }

        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int j : list) {
            res[i] = j;
            i++;
        }

        return res;

    }

    private int traverse(TreeNode root) {
        if (root == null)
            return 0;
        int left = 0;
        int right = 0;
        int count = 0;
        if (root.left != null) {

            left = traverse(root.left);

            count = map.getOrDefault(left, 0) + 1;
            max = Math.max(count, max);
            map.put(left, count);
        }

        if (root.right != null) {
            right = traverse(root.right);
            count = map.getOrDefault(right, 0) + 1;
            max = Math.max(count, max);
            map.put(right, count);

        }

        return left + right + root.val;
    }

    public static void main(String[] args) {
        _508Solution so = new _508Solution();
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(-5);
        root.left = l;
        root.right = r;
        so.findFrequentTreeSum(root);
    }
}
