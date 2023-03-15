package leetcode.leetcode0110;

import sgm.entity.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        return Math.abs(leftHeight-rightHeight) < 2? Math.max(leftHeight, rightHeight) + 1 : -1;
    }
}
