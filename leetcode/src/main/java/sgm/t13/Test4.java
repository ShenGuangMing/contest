package sgm.t13;

import sgm.entity.ListNode;
import sgm.util.NodeUtil;

/*
题目：删除链表中间节点

链接：https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/

要求：给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。

长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。

 */
public class Test4 {
    public static void main(String[] args) {
        Test4 t = new Test4();
        ListNode head = NodeUtil.initLinked();
        ListNode listNode = t.deleteMiddle(head);
        NodeUtil.printLinkedList(listNode);
    }
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = fast.next;
        return head;
    }
}
