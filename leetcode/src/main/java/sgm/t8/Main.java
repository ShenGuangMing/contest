package sgm.t8;

import sgm.entity.ListNode;

/*
题目：合并两个有序链表

链接：https://leetcode.cn/problems/merge-two-sorted-lists/

要求：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        Main main = new Main();
        ListNode res = main.mergeTwoLists2(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode tem = res;
        while (list1 != null || list2 != null) {
            if (list1!=null && (list2 == null || list1.val < list2.val)) {
                tem.next = list1;
                list1=list1.next;
            }else {
                tem.next = list2;
                list2 = list2.next;
            }
            tem = tem.next;
        }
        return res.next;
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        //结束条件
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists1(list1, list2.next);
        return list2;
    }
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode tem = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tem.next = list1;
                list1 = list1.next;
            }else {
                tem.next = list2;
                list2 = list2.next;
            }
            tem = tem.next;
        }
        if (list1 == null)
            tem.next = list2;
        if (list2 == null)
            tem.next = list1;

        return res.next;
    }
}
