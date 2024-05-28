package leetcode.a300;

import java.util.Random;

import leetcode.util.ListNode;

/**
 * 382. Linked List Random Node
 * 一个链表，随机输出里面的节点的值
 * {linked list}
 */
public class _382Solution {

    int length = 1;
    ListNode head;

    public _382Solution(ListNode h) {
        this.head = h;
        ListNode p = h;
        while (p.next != null) {
            p = p.next;
            length++;
        }
    }

    public int getRandom() {
        ListNode cur = head;
        int step = (int) (Math.random() * length);
        while (step != 0) {
            cur = cur.next;
            step--;
        }

        return cur.val;
    }

    // 当链表长度非常长或者不断增长的情况下
    // 无法通过遍历获得链表长度
    // 另外一种水塘抽样算法
    /**
     * 从链表头开始，遍历整个链表，对遍历到的第 i 个节点，
     * 随机选择区间 [0,i) 内的一个整数，如果其等于 0，
     * 则将答案置为该节点值，否则答案不变。
     * 该算法会保证每个节点的值成为最后被返回的值的概率均为 1/n
     */
    class Solution {
        ListNode head;
        Random random;

        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        public int getRandom() {
            int i = 1, ans = 0;
            // 仍然需要遍历
            for (ListNode node = head; node != null; node = node.next) {
                if (random.nextInt(i) == 0) { // 1/i 的概率选中（替换为答案）
                    ans = node.val;
                }
                ++i;
            }
            return ans;
        }
    }

}
