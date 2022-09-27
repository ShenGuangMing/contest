package sgm.t11;

import sgm.entity.ListNode;

/*
题目：环形链表

链接：https://leetcode.cn/problems/linked-list-cycle/

要求：给你一个链表的头节点 head ，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。
仅仅是为了标识链表的实际情况。

如果链表中存在环，则返回 true 。 否则，返回 false 。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
    }
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slowP = head;
        ListNode fastP = head;
        //在一个环中，速度不同一定会相遇
        while (fastP.next != null && fastP.next.next != null) {//结束以快指针为准，它不为null，慢指针也不会为null
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP)
                return true;
        }
        return false;
    }
}
