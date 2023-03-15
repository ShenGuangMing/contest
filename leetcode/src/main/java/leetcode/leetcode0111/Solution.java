package leetcode.leetcode0111;

import sgm.entity.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = Integer.MAX_VALUE;
        int rightHeight = Integer.MAX_VALUE;
        if (root.left != null) {
            leftHeight = minDepth(root.left);
        }
        if (root.right != null) {
            rightHeight = minDepth(root.right);
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(leftHeight, rightHeight) + 1;
    }

}
