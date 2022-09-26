package sgm.util;

import sgm.entity.ListNode;

import java.util.Scanner;

public class ListNodeUtil {
    public static Scanner scanner = new Scanner(System.in);
    public static ListNode initLinked() {
        ListNode head = new ListNode();
        ListNode cur = head;
        int len = scanner.nextInt();
        for (int i = 0; i < len; i++) {
            int n = scanner.nextInt();
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        return head.next;
    }
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
