package leetcode.leetcode0109;

import sgm.entity.ListNode;
import sgm.entity.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
    public TreeNode sortedListToBST(ListNode head) {
        int[] nums = new int[2*10*10*10*10];
        int len = 0;
        while (head!=null) {
            nums[len++] = head.val;
            head = head.next;
        }
        return process1(0, len-1, nums);
    }

    public TreeNode process1(int l, int r, int[] nums) {
        if (l > r) {
            return null;
        }
        int mid = r + (l - r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = process1(l, mid-1, nums);
        node.right = process1(mid+1, r, nums);
        return node;
    }
}
