package leetcode.a200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

/**
 * 二叉搜索树中最接近target的k个数
 * {bst},{queue},{sliding window}
 */
public class _272Solution {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> q = new LinkedList<>();
        inorder(q, root, target, k);
        return new ArrayList<>(q);
    }

    /**
     * 本质上只需要对k长度窗口的两端元素进行比较即可
     * {TODO}原问题可以转换成滑动窗口问题
     * 
     * @param q
     * @param root
     * @param target
     * @param k
     */
    private void inorder(Queue<Integer> q, TreeNode root, double target, int k) {
        if (root == null)
            return;
        inorder(q, root.left, target, k);
        if (q.size() == k) {
            if (Double.compare(Math.abs(q.peek() - target), Math.abs(root.val - target)) > 0) {
                q.poll();
                q.offer(root.val);
            } else
                return;
        } else {
            q.offer(root.val);
        }
        inorder(q, root.right, target, k);
    }
}
