package leetcode.a1500;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import leetcode.util.TreeNode;

/**
 * 设计二叉搜索树的迭代器，支持向前或者向后遍历
 * {design},{bst},{binary tree},{classic}
 */
public class _1586Solution {

    class BSTIterator {

        Deque<TreeNode> stack;
        List<Integer> arr;
        TreeNode last;
        int pointer;

        public BSTIterator(TreeNode root) {
            // last是上一个向后遍历访问的节点
            last = root;
            stack = new ArrayDeque<>();
            arr = new ArrayList<>();
            pointer = -1;
        }

        public boolean hasNext() {
            return !stack.isEmpty() || last != null || pointer < arr.size() - 1;
        }

        public int next() {
            ++pointer;
            // 如果指针超出预计算范围
            if (pointer == arr.size()) {
                // 处理最后一个节点的所有前置任务：
                // 向左走到底，然后向右走一步
                while (last != null) {
                    stack.push(last);
                    last = last.left;
                }
                TreeNode curr = stack.pop();
                last = curr.right;

                arr.add(curr.val);
            }

            return arr.get(pointer);
        }

        public boolean hasPrev() {
            return pointer > 0;
        }

        public int prev() {
            --pointer;
            return arr.get(Math.max(0, pointer));
        }

    }
}
