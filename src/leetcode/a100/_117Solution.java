package leetcode.a100;

/**
 * 给一颗非满二叉树增加层次遍历的指针
 */
public class _117Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 根据上一层的层次遍历顺序可以得到下一层的顺序
     * 
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Node p = root;
        Node L = null;
        Node nextStart = null;

        while (true) {
            L = null;

            while (p != null) {
                // 要建立一个next指向，需要左右两个节点L,current
                // 对每个节点p的左右节点都要遍历
                Node current = p.left;
                if (current != null) {
                    if (L == null) {
                        // 说明是本层的第一个节点
                        L = current;
                        nextStart = current;
                    } else {
                        L.next = current;
                        L = current;
                    }
                }
                current = p.right;
                if (current != null) {
                    if (L == null) {
                        // 说明是本层的第一个节点
                        L = current;
                        nextStart = current;
                    } else {
                        L.next = current;
                        L = current;
                    }
                }

                p = p.next;
            }
            if (L != null) // 如果最后L还是null，那么说明这层已经没有节点了，可以退出。
                p = nextStart;
            else
                break;
        }

        return root;
    }
}
