package leetcode.a500;

import java.util.LinkedList;
import java.util.List;

import leetcode.util.TreeNode;
/**
 * 把bst树转换成累加树
 * 累加树是指节点原来的值加上所有比该节点大的节点的值的和
 * {bst},{prefix sum}
 */
public class _538Solution {

    int i = 0;
    int total;
    int j = 0;

    /**
     * 一开始中根遍历求出前缀和，然后再执行一遍修改值
     * 不如直接从大到小遍历
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {

        if (root == null)
            return root;

        List<Integer> prefix = new LinkedList<>();

        countPrefix(root, prefix);

        total = prefix.get(prefix.size() - 1);

        changeValue(root, prefix);

        return root;

    }

    private void countPrefix(TreeNode node, List<Integer> prefix) {

        if (node == null)
            return;

        countPrefix(node.left, prefix);

        i += node.val;
        prefix.add(i);
        countPrefix(node.right, prefix);
    }

    private void changeValue(TreeNode node, List<Integer> prefix) {
        if (node == null)
            return;

        changeValue(node.left, prefix);

        node.val += total - prefix.get(j++);
        changeValue(node.right, prefix);
    }

    int sum;

    /**
     * 可以直接从大到小遍历
     * @param root
     * @return
     */
    public TreeNode convertBST1(TreeNode root) {
        sum = 0;
        convert(root);
        return root;
    }

    // 按右中左顺序遍历，累加即可
    public void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        convert(root.right);
        sum += root.val;
        root.val = sum;
        convert(root.left);
    }
}
