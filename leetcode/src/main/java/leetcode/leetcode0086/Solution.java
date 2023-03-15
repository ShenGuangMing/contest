package leetcode.leetcode0086;

import sgm.entity.ListNode;
import sgm.util.NodeUtil;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        ListNode listNode = NodeUtil.initLinked();
//        NodeUtil.printLinkedList(solution.partition(listNode, 2));
        System.out.println(6982651.0 / (24 * 60 * 60));
    }
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(head, 0);
        ListNode smallHead = small;
        ListNode large = new ListNode(head, 0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
