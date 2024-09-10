package leetcode.a200;

import java.util.Stack;

/**
 * 校验一个bst的先根遍历数组是否正确
 * {bst},{TODO}
 */
public class _255Solution {
    /**
     * 用栈模拟bst的先根遍历
     * 先根遍历前面已经遍历过得节点一定是某个子树根
     * 
     * @param preorder
     * @return
     */
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack<>();
        for (int p : preorder) {
            if (p < low)
                return false;
            while (!path.empty() && p > path.peek())
                low = path.pop();
            path.push(p);
        }
        return true;
    }
}
