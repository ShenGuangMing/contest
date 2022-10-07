package sgm.t16;

import sgm.entity.ListNode;
import sgm.util.NodeUtil;

public class Test5 {
    public static void main(String[] args) {
        ListNode head = NodeUtil.initLinked();
        NodeUtil.printLinkedList(rotateRight(head, 2));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode last = null;
        int len = 0;//求链表长度
        while (cur != null) {
            len++;
            last = cur;
            cur = cur.next;
        }
        if (k%len == 0){
            return head;
        }
        //取模相减，得到距离
        int distance = len - (k % len);
        ListNode prev = head;
        cur = head;
        while (distance>0) {
            prev = cur;
            cur = cur.next;
            distance--;
        }
        last.next = head;
        prev.next = null;
        return cur;
    }
}
