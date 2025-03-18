package leetcode.a400;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import leetcode.util.TreeNode;

/**
 * bst序列化和反序列化
 * {bst},{design}
 */
public class _449Solution {

    public class Codec {

        public String serialize(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            postOrder(root, list);
            String str = list.toString();
            return str.substring(1, str.length() - 1);
        }

        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] arr = data.split(", ");
            Deque<Integer> stack = new ArrayDeque<Integer>();
            int length = arr.length;
            for (int i = 0; i < length; i++) {
                stack.push(Integer.parseInt(arr[i]));
            }
            return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
        }

        private void postOrder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.val);
        }

        private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
            // <lower || >upper 说明到达了该层的边界，下面弹出的节点不属于当前节点的子树
            if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
                return null;
            }
            int val = stack.pop();
            TreeNode root = new TreeNode(val);
            root.right = construct(val, upper, stack);
            root.left = construct(lower, val, stack);
            return root;
        }

    }

    /**
     * 用char保存节点速度明显更快
     */
    public class Codec1 {
        char NL = 'x';
        char spliter = '#';

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            sHelper(root, sb);
            return sb.toString();
        }

        public void sHelper(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NL);
                sb.append(spliter);
                return;
            }
            sb.append(root.val);
            sb.append(spliter);
            sHelper(root.left, sb);
            sHelper(root.right, sb);

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            int[] arr = new int[1];
            return dHelper(data, arr);

        }

        /**
         * 把arr[0]用作保存当前遍历到的位置
         * 
         * @param data
         * @param arr
         * @return
         */
        public TreeNode dHelper(String data, int[] arr) {
            char first = data.charAt(arr[0]);
            if (first == NL) {
                arr[0] += 2;
                return null;
            } else {
                int num = 0;
                int currIdx = arr[0];
                while (currIdx < data.length() && data.charAt(currIdx) != spliter) {
                    num = num * 10 + (data.charAt(currIdx++) - '0');
                }
                arr[0] = currIdx + 1;
                TreeNode root = new TreeNode(num);
                root.left = dHelper(data, arr);
                root.right = dHelper(data, arr);
                return root;
            }
        }
    }

    /**
     * 直接用单个字符保存节点的值
     * 占用空间最小
     */
    public class Codec2 {

        // 空树不能使用普通字符表示，否则正常节点可能被解析为空直接返回
        // 树的结构会不完整
        // char NL = 'x';
        char NL = '\uFFFF';
        // char spliter = '#';

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            sHelper(root, sb);
            return sb.toString();
        }

        public void sHelper(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NL);
                // sb.append(spliter);
                return;
            }
            sb.append((char)('0'+root.val));
            // sb.append(spliter);
            sHelper(root.left, sb);
            sHelper(root.right, sb);

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            int[] arr = new int[1];
            return dHelper(data, arr);

        }

        public TreeNode dHelper(String data, int[] arr) {
            char first = data.charAt(arr[0]);
            if (first == NL) {
                arr[0] += 1;
                return null;
            } else {

                int num = data.charAt(arr[0]++) - '0';
                TreeNode root = new TreeNode(num);
                root.left = dHelper(data, arr);
                root.right = dHelper(data, arr);
                return root;
            }
        }
    }
}
