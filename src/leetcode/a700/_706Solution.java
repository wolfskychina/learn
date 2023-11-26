package leetcode.a700;
/**
 * 设计一个{hashmap}
 */
public class _706Solution {

    /**
     * 链表法解决冲突
     * {design}
     */
    class MyHashMap {
        ListNode[] list = new ListNode[10000];

        /** Initialize your data structure here. */
        public MyHashMap() {

        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int ind = ind(key);
            ListNode prev = findPrev(ind, key);
            if (prev.next == null) {
                prev.next = new ListNode(key, value);
            } else {
                prev.next.value = value;
            }
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map
         * contains no mapping for the key
         */
        public int get(int key) {
            ListNode prev = findPrev(ind(key), key);
            return prev.next == null ? -1 : prev.next.value;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping
         * for the key
         */
        public void remove(int key) {
            ListNode prev = findPrev(ind(key), key);
            if (prev.next != null) {
                ListNode next = prev.next.next;
                prev.next = next;
            }
        }

        private ListNode findPrev(int ind, int key) {
            if (list[ind] == null) {
                list[ind] = new ListNode(-1, -1);
                return list[ind];
            }
            ListNode prev = list[ind];
            while (prev.next != null && prev.next.key != key) {
                prev = prev.next;
            }
            return prev;
        }

        private int ind(int i) {
            return Integer.hashCode(i) % list.length;
        }

        private class ListNode {
            int key, value;

            ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            ListNode next;
        }
    }
}
