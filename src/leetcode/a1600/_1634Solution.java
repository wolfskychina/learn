package leetcode.a1600;

import leetcode.util.listnode.PolyNode;

/**
 * {linkedlist},{easy}
 */
public class _1634Solution {

    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummy = new PolyNode();
        PolyNode p = dummy;
        while (poly1 != null && poly2 != null) {
            if (poly1.power == poly2.power) {
                poly1.coefficient += poly2.coefficient;
                if (poly1.coefficient != 0) {
                    p.next = poly1;
                    p = p.next;
                }

                poly1 = poly1.next;
                poly2 = poly2.next;

            } else if (poly1.power < poly2.power) {
                p.next = poly2;
                p = p.next;
                poly2 = poly2.next;

            } else {
                p.next = poly1;
                p = p.next;
                poly1 = poly1.next;
            }
        }

        if (poly1 == null) {
            p.next = poly2;
        } else {
            p.next = poly1;
        }

        return dummy.next;
    }
}
