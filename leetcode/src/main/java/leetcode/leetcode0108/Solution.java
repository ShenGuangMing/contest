package leetcode.leetcode0108;

import sgm.entity.TreeNode;
import sgm.util.NodeUtil;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.sortedArrayToBST(new int[]{1, 2, 3});

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return process1(0, nums.length-1, nums);
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
