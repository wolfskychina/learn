package leetcode.a1100;

import java.util.HashMap;

import leetcode.util.ListNode;

/**
 * 将链表中连续段的区间节点和为0的段全部删除
 * {linkedlist},{prefix sum},{hashmap}
 */
public class _1171Solution {

    /**
     * 能想到是和前缀和相关，也想到了使用hashmap保存前缀和对应的节点
     * 在删节点时怎么去掉hashmap中被删除节点对应的前缀和没考虑清楚
     * 删掉这些节点之后，当前的最后节点的前缀和sum其实没变
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        // <sum, lastNode>
        HashMap<Integer, ListNode> sumMap = new HashMap<>();
        ListNode dummy = new ListNode(-1, head);
        ListNode p = head;
        int sum = 0;
        sumMap.put(0, dummy);
        while (p != null) {
            sum += p.val;
            if (sumMap.containsKey(sum)) {
                ListNode node = sumMap.get(sum);
                ListNode del = node.next;
                node.next = p.next;

                int dSum = sum;
                // 把删除的段从前缀和的映射表里面去掉
                while (del != p) {
                    dSum += del.val;
                    sumMap.remove(dSum);
                    del = del.next;
                }

            } else {
                sumMap.put(sum, p);
            }
            p = p.next;
        }
        return dummy.next;

    }
}
