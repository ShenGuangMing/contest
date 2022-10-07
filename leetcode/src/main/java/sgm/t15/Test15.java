package sgm.t15;

import sgm.entity.ListNode;
import sgm.util.NodeUtil;

public class Test15 {
    public static void main(String[] args) {
        ListNode head = NodeUtil.initLinked();
        ListNode node = reverseBetween(head, 2, 4);
        NodeUtil.printLinkedList(node);
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null)
            return head;
        ListNode p = head;
        ListNode cur = head;
        int index = 1;
        while (index < left) {
            p = cur;
            cur = cur.next;
            index++;
        }
        ListNode node = cur;
        ListNode prev = cur;
        ListNode next = null;
        cur = cur.next;
        index = right - left;
        while (index > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            index--;
        }
        if (left == 1) {
            p.next = cur;
            return prev;
        }else {
            node.next = cur;
            p.next = prev;
            return head;
        }
    }

}
