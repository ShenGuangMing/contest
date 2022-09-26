package sgm.t9;

import sgm.entity.ListNode;

/*
题目：删除有序链表中的重复元素

链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list/

要求：给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

    }
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null)
            return head;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {//当前节点的值等于下一个节点的值
                curr.next = curr.next.next;
            }else
                curr = curr.next;
        }
        return head;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if ( head == null || head.next == null)
            return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
