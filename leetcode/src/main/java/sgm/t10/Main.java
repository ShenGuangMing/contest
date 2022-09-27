package sgm.t10;
/*
题目：删除链表中重复的元素||

链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/

要求：给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */

import sgm.entity.ListNode;
import sgm.util.NodeUtil;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode head = NodeUtil.initLinked();
        ListNode listNode = main.deleteDuplicates(head);
        NodeUtil.printLinkedList(listNode);
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode res = new ListNode();
        ListNode temp = res;
        ListNode cur = head;
        int prev = Integer.MIN_VALUE;
        while (cur != null) {
            if (cur.val == prev) {
                cur = cur.next;
                continue;
            }
            if (cur.next != null && cur.val == cur.next.val) {
                prev = cur.val;
                cur = cur.next;
                continue;
            }
            temp.next = new ListNode(cur.val);
            temp = temp.next;
            cur = cur.next;
        }
        return res.next;
    }
}
