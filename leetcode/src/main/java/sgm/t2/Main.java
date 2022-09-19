package sgm.t2;

import sgm.entity.ListNode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode l1 = new ListNode(9);
        ListNode current = l1;
        for (int i = 0; i < 1; i++) {
            current.next = new ListNode(9);
            current = current.next;
        }
        ListNode l2 = new ListNode(9);
        current = l2;
        for (int i = 0; i < 1; i++) {
            current.next = new ListNode(9);
            current = current.next;
        }
        ListNode res = main.addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val +" ");
            res = res.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;
        int cry = 0;//进位
        int sum = cry;
        while (l1!=null || l2!=null || cry!=0 ) {
            sum = cry;
            if (l1 !=null) {
                sum += l1.val;//把节点中的数取出
                l1 = l1.next;
            }
            if (l2 !=null) {
                sum += l2.val;//把节点中的数取出
                l2 = l2.next;
            }
            current.next = new ListNode(sum%10);
            current = current.next;
            cry = sum/10;
        }
        return head.next;
    }
}
