package leetcode.a400;

import java.util.LinkedList;
import java.util.Stack;
import leetcode.util.narray.Node;

/**
 * N叉树的序列化与反序列化
 * {design},{tree},{classic}
 */
public class _428Solution {

    class Codec {

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            StringBuilder sb = new StringBuilder();
            if (root == null) {
                return sb.toString();
            }
            encode(root, sb);
            return sb.toString();
        }

        private void encode(Node node, StringBuilder sb) {
            if (node == null) {
                return;
            }
            sb.append(node.val);
            sb.append(" ");

            boolean hasChildren = !node.children.isEmpty();

            // only append "[ ]" when the node has children
            if (hasChildren) {
                sb.append("[ ");
            }
            for (int i = 0; i < node.children.size(); i++) {
                Node children = node.children.get(i);
                encode(children, sb);
                // 去掉结尾多余的空格
                if (i == node.children.size() - 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            if (hasChildren) {
                sb.append(" ] ");
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] strings = data.split(" ");
            Stack<Node> stack = new Stack<Node>();
            Node root = null;
            Node cur = null;

            for (String s : strings) {
                if (s.equals("[")) {
                    stack.push(cur);
                } else if (s.equals("]")) {
                    stack.pop();
                } else {
                    Node node = new Node(Integer.valueOf(s));
                    node.children = new LinkedList<Node>();
                    if (root == null) {
                        root = node;
                    } else {
                        Node parent = stack.peek();
                        parent.children.add(node);
                    }
                    cur = node;
                }
            }

            return root;
        }
    }
}
