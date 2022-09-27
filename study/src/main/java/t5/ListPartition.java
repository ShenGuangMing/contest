package t5;

import entity.ListNode;
import util.NodeUtil;

public class ListPartition {
    public static void main(String[] args) {
        ListNode head = NodeUtil.initLinked();
        ListNode listNode = listPartiton1(head, 3);
        NodeUtil.printLinkedList(listNode);

    }

    public static ListNode listPartiton(ListNode head, int target) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        cur = head;
        ListNode[] list = new ListNode[len];
        for (int i = 0; i < len; i++) {
            list[i] = cur;
            cur = cur.next;
        }
        int left = -1;
        int right = len;
        int i = 0;
        //Partiton过程
        while (i < right) {
            if (list[i].val < target) {
                swap(list, i++, ++left);
            } else if (list[i].val > target) {
                swap(list, i, --right);
            } else {
                i++;
            }
        }
        cur = list[0];
        head = list[0];
        for (int j = 1; j < len; j++) {
            cur.next = list[j];
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    public static ListNode listPartiton1(ListNode head, int target) {
        ListNode sH = null;
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode mH = null;
        ListNode mT = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < target) {
                if (sH == null) {
                    sH = cur;
                    sT = cur;
                }else{
                    sT.next = cur;
                    sT = cur;
                }
            }else if (cur.val == target) {
                if (eH == null) {
                    eH = cur;
                    eT = cur;
                }else {
                    eT.next = cur;
                    eT = cur;
                }
            }else {
                if (mH == null) {
                    mH = cur;
                    mT = cur;
                }else {
                    mT.next = cur;
                    mT = cur;
                }
            }
            cur = cur.next;
        }
        if (sT != null)
            sT.next = null;
        if (eT != null)
            eT.next = null;
        if (mT != null)
            mT.next = null;
        NodeUtil.printLinkedList(sH);
        NodeUtil.printLinkedList(eH);
        NodeUtil.printLinkedList(mH);
        //1 4 3 5 2
//        if (sT != null) {
//            if (eT != null) {//小有等有
//                sT.next = eH;
//                if (mT != null)
//                    eT.next = mH;
//            }else {//小有等没有
//                sT.next = mH;
//            }
//            return sH;
//        }else {
//            if (eT != null) {//小无等有
//                eT.next = mH;
//                return eH;
//            }else {//小无等无
//                return mH;
//            }
//        }

        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = mH;
        }
        return sH != null? sH : (mH != null ? mH : eT);
    }


        public static void swap(ListNode[] arr, int i, int j) {
        ListNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
