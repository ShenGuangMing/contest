package sgm.t13;

import sgm.entity.ListNode;

public class Test2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode n1 = headA;
        ListNode n2 = headB;
        while (n1 != n2) {//会让两指针在同一相对位置，会同时结束
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }
}
