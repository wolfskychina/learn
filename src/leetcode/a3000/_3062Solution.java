package leetcode.a3000;

import leetcode.util.ListNode;

/**
 * 链表游戏的获胜者
 * {easy}
 */
public class _3062Solution {

    public String gameResult(ListNode head) {

        int score = 0;
        while (head != null) {
            if (head.val > head.next.val) {
                score++;
            } else if (head.val < head.next.val) {
                score--;
            }
            head = head.next.next;

        }
        if (score > 0) {
            return "Even";
        } else if (score < 0) {
            return "Odd";
        } else {
            return "Tie";
        }
    }
}
