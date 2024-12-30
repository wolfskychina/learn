package leetcode.a1300;

import leetcode.util.ListNode;
import leetcode.util.TreeNode;

/**
 * 判断一个链表代表的数字序列是否存在于一棵二叉树的自顶向下的路径上
 * {binary tree},{linked list}
 */
public class _1367Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean dfs(TreeNode rt, ListNode head) {
        // 链表已经全部匹配完，匹配成功
        if (head == null) {
            return true;
        }
        // 二叉树访问到了空节点，匹配失败
        if (rt == null) {
            return false;
        }
        // 当前匹配的二叉树上节点的值与链表节点的值不相等，匹配失败
        if (rt.val != head.val) {
            return false;
        }
        return dfs(rt.left, head.next) || dfs(rt.right, head.next);
    }
}
