package t4;

import entity.ListNode;
import util.NodeUtil;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode listNode = NodeUtil.initLinked();
        PalindromeLinkedList p = new PalindromeLinkedList();
        boolean palindrome = p.isPalindrome2(listNode);
        System.out.println(palindrome);
    }

    public boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val)
                return false;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head != null && head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = slow.next;
        while (slow!=null){
            stack.push(slow);
            slow = slow.next;
        }
        while (head != null && !stack.isEmpty()) {
            if (head.val != stack.pop().val)
                return false;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head != null && head.next == null)
            return true;
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        ListNode n3 = null;
        n1 = n1.next;
        n2 = n1.next;
        n1.next = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = head;
        while (n1 != null) {
            if (n3.val != n1.val){
                return false;
            }
            n3 = n3.next;
            n1 = n1.next;
        }
        return true;
    }
}
