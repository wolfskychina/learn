package leetcode.a300;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;
/**
 * 366. Find Leaves of Binary Tree
 * 依次输出遍历叶子结点，每趟输出叶子结点之后，将本次的叶子结点删除
 * 下次输出新形成的叶子结点
 */
public class _366Solution {

    /**
     * 层次遍历稍微修改一下
     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves(TreeNode root) {

        // 层次遍历
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;

        while (root.left != null || root.right != null) {

            List<Integer> list = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {

                TreeNode node = q.poll();
                if (node.left != null) {
                    if (node.left.left == null && node.left.right == null) {
                        list.add(node.left.val);
                        node.left=null;
                    } else {
                        q.offer(node.left);
                    }

                }
                if (node.right != null) {
                    if (node.right.left == null && node.right.right == null) {
                        list.add(node.right.val);
                        node.right =null;
                    } else {
                        q.offer(node.right);
                    }
                }
            }
            res.add(list);

        }

        List<Integer> list = new LinkedList<>();
        list.add(root.val);
        res.add(list);
        return res;
        

    }
}
