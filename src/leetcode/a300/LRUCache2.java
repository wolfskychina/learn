package leetcode.a300;

import java.util.HashMap;
import java.util.Map;

class LRUCache2 {

    private class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node dummy;
    private Node tail;

    private Map<Integer, Node> map;

    private int capacity = 0;

    public LRUCache2(int capacity) {

        this.capacity = capacity;
        dummy = new Node(-1, -1);
        dummy.next = null;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {

        Node a = map.get(key);

        if (a == null)
            return -1;
        if (a != dummy.next) {
            remove(a);
            add(a);
        }

        return a.value;
    }

    public void put(int key, int value) {

        if (map.get(key) != null) {
            Node a = map.get(key);
            a.value = value;
            remove(a);
            add(a);
        } else {
            if (map.size() == capacity) {
                int headKey = tail.key;
                map.remove(headKey);
                Node newTail = tail.pre;
                tail.pre = null;
                tail.next = null;
                tail = newTail;
            }
            Node a = new Node(key, value);
            map.put(key, a);
            add(a);
        }
    }

    private void remove(Node a) {
        Node pre = a.pre;
        Node next = a.next;
        a.pre = null;
        a.next = null;
        pre.next = next;
        if (null != next)
            next.pre = pre;
    }

    private void add(Node a) {
        Node head = dummy.next;
        dummy.next = a;
        a.next = head;
        a.pre = dummy;
        if (null != head)
            head.pre = a;
    }

}