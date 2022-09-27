package t4;

import entity.ListNode;
import util.NodeUtil;

public class LinkReverse {
    public static void main(String[] args) {
        ListNode listNode = NodeUtil.initLinked();
        ListNode reverse = reverse(listNode);
        NodeUtil.printLinkedList(reverse);
    }
    public static ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        ListNode n1 = head;
        ListNode n2 = n1.next;
        ListNode n3 = null;
        n1.next = null;//将头节点下个只想null
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        return n1;
    }
}
