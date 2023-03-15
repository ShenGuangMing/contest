package leetcode.leetcode0112;

import sgm.entity.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.val == targetSum) {
            if (root.left == null && root.right == null)
                return true;
        }
        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
    }


}
