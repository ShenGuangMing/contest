package sgm.t13;

import sgm.entity.ListNode;

/*
题目：链表的中间节点

链接：https://leetcode.cn/problems/middle-of-the-linked-list/

要求：给定一个头结点为 head 的非空单链表，返回链表的中间结点。

如果有两个中间结点，则返回第二个中间结点。
 */
public class Test3 {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next == null) {
            return slow;
        }
        return slow.next;

    }
}
