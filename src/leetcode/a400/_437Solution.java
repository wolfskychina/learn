package leetcode.a400;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import leetcode.util.TreeNode;

public class _437Solution {

    int num = 0;

    /**
     * 使用前缀和的递归，很慢仅战胜了7%
     * 
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {

        if (root == null)
            return 0;
        if (root.left == null && root.right == null &&
                root.val == targetSum)
            return 1;

        List<Long> list = new LinkedList<>();
        list.add(0L);
        if (root.val == targetSum)
            num = 1;
        list.add((long) root.val);
        if (root.left != null) {
            findChild(list, targetSum, root.left);

        }
        if (root.right != null) {
            findChild(list, targetSum, root.right);
        }

        return num;

    }

    private void findChild(List<Long> list, int target, TreeNode node) {

        list.add(list.get(list.size() - 1) + node.val);
        Long a = list.get(list.size() - 1);
        for (int i = list.size() - 2; i >= 0; i--) {
            if (a - list.get(i) == target)
                num++;
        }

        if (node.left != null) {
            findChild(list, target, node.left);

        }
        if (node.right != null) {
            findChild(list, target, node.right);
        }

        list.remove(list.size() - 1);
    }

    /**
     * 将路径中的前缀和改为map<preFix,count>表示之前路径和中各种前缀出现的次数
     * 战胜了86%的用户
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum1(TreeNode root, int targetSum) {

        if (root == null)
            return 0;
        if (root.left == null && root.right == null &&
                root.val == targetSum)
            return 1;

        Map<Long, Integer> preMap = new HashMap<>();
        preMap.put(0L, 1);

        findChild(preMap, targetSum, 0L, root);

        return num;

    }

    private void findChild(Map<Long, Integer> map, int target, long preSum, TreeNode node) {

        if (node == null)
            return;

        long newSum = preSum + node.val;
        num += map.getOrDefault(newSum - target, 0);
        map.put(newSum, map.getOrDefault(newSum, 0) + 1);

        findChild(map, target, newSum, node.left);

        findChild(map, target, newSum, node.right);

        map.put(newSum, map.get(newSum) - 1);

    }

}
