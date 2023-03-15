package leetcode.leetcode0104;

import sgm.entity.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
