package leetcode.a700;

import leetcode.util.listnode.Node;
/**
 * 循环有序链表中插入一个val大小的节点,
 * 给定的起始点head并不一定是最小值所在的点
 * {circled linkedlist}
 */
public class _708Solution {

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        if (head.next == head) {
            Node p = new Node(insertVal);
            p.next = head;
            head.next = p;
            return head;
        }

        Node p = head;
        while (p.next != head && p.val <= p.next.val) {
            p = p.next;
        }

        if (p.next == head && p.val == p.next.val) {
            Node node = new Node(insertVal);
            node.next = p.next;
            p.next = node;
            return head;
        }

        // p.next is the smallest element
        Node p0 = p;
        while (p.next.val < insertVal) {
            p = p.next;
            // 注意终止条件，避免死循环
            if (p == p0)
                break;
        }
        Node node = new Node(insertVal);
        node.next = p.next;
        p.next = node;
        return head;

    }

    public static void main(String[] args) {

        // 1,3,5 5
        _708Solution so = new _708Solution();
        Node head = new Node(1);
        Node p2 = new Node(3);
        Node p3 = new Node(5);
        head.next = p2;
        p2.next = p3;
        p3.next = head;
        so.insert(head, 5);
    }
}
