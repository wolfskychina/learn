package leetcode.a2000;

import leetcode.util.ListNode;

/**
 * 临界点之间的最小距离和最大距离
 * {linkedlist},{easy}
 */
public class _2058Solution {

    public int[] nodesBetweenCriticalPoints(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return new int[] { -1, -1 };

        int cur = 0;
        int first = -1;
        int last = -1;
        int min = Integer.MAX_VALUE;
        while (head.next.next != null) {

            if ((head.next.val > head.val && head.next.val > head.next.next.val)
                    || (head.next.val < head.val && head.next.val < head.next.next.val)) {
                if (first == -1) {
                    first = cur;
                    last = cur;
                } else {
                    min = Math.min(min, cur - last);
                    last = cur;
                }
            }
            head = head.next;
            cur++;
        }

        if (first == last)
            return new int[] { -1, -1 };

        return new int[] { min, last - first };

    }

    public static void main(String[] args) {

        _2058Solution so = new _2058Solution();

    }
}
