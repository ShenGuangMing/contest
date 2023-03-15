package sgm.util;

import sgm.entity.ListNode;
import sgm.entity.TreeNode;

import java.util.Scanner;

public class NodeUtil {
    public static Scanner scanner = new Scanner(System.in);
    public static ListNode initLinked() {
        ListNode head = new ListNode();
        ListNode cur = head;
        System.out.print("输入节点数：");
        int len = scanner.nextInt();
        System.out.print("输入每个节点值：");
        for (int i = 0; i < len; i++) {
            int n = scanner.nextInt();
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        return head.next;
    }
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void printPreOrderTreeNodes(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val+" ");
        printPreOrderTreeNodes(node.left);
        printPreOrderTreeNodes(node.right);
    }
    public static void printInOrderTreeNodes(TreeNode node) {
        if (node == null)
            return;
        printInOrderTreeNodes(node.left);
        System.out.print(node.val + " ");
        printInOrderTreeNodes(node.right);
    }
}
