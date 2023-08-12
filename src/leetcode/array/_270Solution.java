package leetcode.array;

import leetcode.util.TreeNode;

/**
 * 在一棵bst中查找和n大小最接近的值
 * bst中节点值为整数，n为浮点数
 */
public class _270Solution {

    /**
     * 在遍历的时候总是保存当前的最小值
     * 注意当两次比较的差值相同时，说明遇到了0.5的情况，
     * 按照题目要求，需要保存更小的值
     * @param root
     * @param target
     * @return
     */
    public int closestValue(TreeNode root, double target) {
        int ret = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) == Math.abs(target - ret)) {
                ret = Math.min(ret, root.val);
            }
            if (Math.abs(target - root.val) < Math.abs(target - ret)) {
                ret = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return ret;
    }
}
