package t5;

import entity.ListNode;
//寻找第一个相交节点
public class FindFirstIntersectionNode {

    public static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return null;
        ListNode loop1 = containsLoop(head1);
        ListNode loop2 = containsLoop(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;

    }

    //无环链表寻找相交节点
    public static ListNode noLoop(ListNode aH, ListNode bH) {
        ListNode n1 = aH;
        ListNode n2 = bH;
        while (n1 != n2) {
            n1 = n1 == null ? bH : n1.next;
            n2 = n2 == null ? aH : n2.next;
        }
        return n1;
    }
    //有环的两个相交节点，且入环节点相同，查找第一个相交节点
    public static ListNode hasLoop(ListNode aH, ListNode bH, ListNode target) {
        ListNode n1 = aH;
        ListNode n2 = bH;
        while (n1 != n2) {
            n1 = n1 == target ? bH : n1.next;
            n2 = n2 == target ? aH : n2.next;
        }
        return n1;
    }
    //两个有环节点查找相交节点，相交返回第一个相交节点，如果不相交返回null
    public static ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        ListNode cur1 = null;
        if (loop1 == loop2) {
            return hasLoop(head1, head2, loop1);
        }else {
            cur1 = loop1.next;
            while (cur1 != loop1) {//转一圈看能不能遇到loop2
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            //没有遇到就退出循环了
            return null;
        }
    }
    //链表中是否存在环
    public static ListNode containsLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean contains = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                contains = true;
                break;
            }
        }
        if (!contains) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
