package leetcode.a1200;

/**
 * 倒序打印一个链表,不允许改变链表节点的指向
 * {easy},{recursive}
 */
public class _1265Solution {

    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null)
            return;
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }

    private interface ImmutableListNode{

        ImmutableListNode getNext();

        void printValue();

    }
}
