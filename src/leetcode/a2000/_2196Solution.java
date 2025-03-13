package leetcode.a2000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import leetcode.util.TreeNode;

/**
 * 根据节点上下级关系创建二叉树
 * {binary tree},{easy}
 */
public class _2196Solution {

    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> map = new HashMap<>();
        for (int d[] : descriptions) {

            TreeNode p;
            TreeNode s;
            if (map.get(d[0]) == null) {
                p = new TreeNode(d[0]);
                map.put(d[0], p);
            } else {
                p = map.get(d[0]);
            }
            if (map.get(d[1]) == null) {
                s = new TreeNode(d[1]);
                map.put(d[1], s);
            } else {
                s = map.get(d[1]);
            }

            if (d[2] == 1) {
                p.left = s;
            } else {
                p.right = s;
            }

        }
        // find the root;
        Set<Integer> set = new HashSet<>(map.keySet());
        for (int d[] : descriptions) {
            set.remove(d[1]);
        }
        for (int i : set) {
            return map.get(i);
        }

        return null;
    }

    /**
     * 使用数组保存索引比HashMap快很多
     * 额外用了一个标记节点是否是子节点的数组
     * 加速寻找根节点
     * @param nums
     * @return
     */
    public TreeNode createBinaryTree1(int[][] nums) {
        TreeNode[] tree = new TreeNode[100001];
        boolean[] isChild = new boolean[100001];

        for (int[] num : nums) {
            int parent = num[0];
            int child = num[1];

            if (tree[parent] == null) {
                tree[parent] = new TreeNode(parent);
            }
            if (tree[child] == null) {
                tree[child] = new TreeNode(child);
            }
            if (num[2] == 1) {
                tree[parent].left = tree[child];
            } else {
                tree[parent].right = tree[child];
            }
            isChild[child] = true;
        }
        for (int[] num : nums) {
            if (!isChild[num[0]])
                return tree[num[0]];
        }
        return null;
    }
}
