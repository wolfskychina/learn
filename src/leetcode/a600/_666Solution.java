package leetcode.a600;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树到叶子结点的路径之和
 * 二叉树使用的是数字编码而不是对象指向
 * 百位表示所在层数，十位表示在所在层从左往右的顺序，个位表示节点的值
 * {binary tree}
 */
public class _666Solution {

    int sum = 0;

    /**
     * 注意叶子结点是左右子树均为null，如果仅有一个子树为null
     * 此时不应该算作一条路径
     * 
     * @param nums
     * @return
     */
    public int pathSum(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i / 10, i % 10);
        }
        computeSum(nums[0] / 10, 0, map);
        return sum;

    }

    private void computeSum(int idx, int currSum, Map<Integer, Integer> map) {

        // nextL是左子树的坐标
        int nextL = (idx / 10 + 1) * 10 + (idx % 10 - 1) * 2 + 1;
        currSum += map.get(idx);

        if (!map.containsKey(nextL) && !map.containsKey(nextL + 1)) {
            sum += currSum;
            return;
        }

        // 左子树
        if (map.containsKey(nextL))
            computeSum(nextL, currSum, map);
        // 右子树
        if (map.containsKey(nextL + 1))
            computeSum(nextL + 1, currSum, map);

    }
}
