package leetcode.a1000;

import leetcode.util.TreeNode;

/**
 * 前序遍历构造二叉搜索树
 * {bst},{classic}
 */
public class _1008Solution {

    /**
     * 前序遍历区间第一个节点是根节点，左子树在前半区间，右子树在后半区间
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {

        return formPreorder(preorder, 0, preorder.length - 1);

    }

    private TreeNode formPreorder(int[] arr, int l, int r) {
        if (l > r)
            return null;
        TreeNode p = new TreeNode(arr[l]);
        int mid = findMax(arr, l + 1, r);

        p.left = formPreorder(arr, l + 1, mid - 1);
        p.right = formPreorder(arr, mid, r);
        return p;

    }

    private int findMax(int[] arr, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (arr[i] > arr[l - 1]) {

                return i;
            }
        }
        return r + 1;
    }
}
