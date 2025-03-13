package leetcode.a800;

import leetcode.util.TreeNode;

/**
 * 根据前序和后序序列构造二叉树
 * {binary tree},{classic}
 */
public class _889Solution {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        return construct(0, preorder.length - 1, 0, preorder.length - 1, preorder, postorder);
    }

    private TreeNode construct(int start1, int end1, int start2, int end2, int[] pre, int[] post) {

        if (start1 > end1)
            return null;
        TreeNode root = new TreeNode(pre[start1]);
        if (start1 == end1)
            return root;
        int i = start1 + 1;
        int j = start2;

        // 需要特殊注意区间只能构成一侧子树得情况，不考虑这个只用另一半逻辑会溢出
        if (pre[start1 + 1] == post[end2 - 1]) {
            // 说明只有一个子树
            root.left = construct(start1 + 1, end1, start2, end2 - 1, pre, post);
            root.right = null;

        } else {
            // next position of pre is start1+1
            for (; i < end1; i++) {
                if (pre[i] == post[end2 - 1])
                    break;
            } // i-1
            for (; j < end2 - 1; j++) {
                if (post[j] == pre[start1 + 1])
                    break;
            }

            root.left = construct(start1 + 1, i - 1, start2, j, pre, post);
            root.right = construct(i, end1, j + 1, end2 - 1, pre, post);
        }

        return root;
    }

    public static void main(String[] args) {
        _889Solution so = new _889Solution();
        int[] pre = { 6, 10, 8, 5, 4, 2, 9, 3, 1, 7 };
        int[] post = { 2, 3, 9, 4, 7, 1, 5, 8, 10, 6 };
        so.constructFromPrePost(pre, post);
    }
}
