package sgm.t13;

import sgm.entity.ListNode;
import sgm.util.NodeUtil;

/*
题目：反转链表

链接：https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/

要求：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        ListNode node = NodeUtil.initLinked();
        ListNode reverse = t.reverseList(node);
        NodeUtil.printLinkedList(reverse);
    }
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode n1 = head;
        ListNode n2 = n1.next;
        ListNode n3 = null;
        n1.next = null;//将头节点下个指向null
        while (n2 != null) {
            n3 = n2.next;//最后一个后移
            n2.next = n1;//当前节点向前指
            n1 = n2;//第一个节点等于当前节点
            n2 = n3;
        }
        return n1;
    }
}
