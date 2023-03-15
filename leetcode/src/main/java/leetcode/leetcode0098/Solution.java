package leetcode.leetcode0098;

import sgm.entity.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
    long preVal = 0;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if(!isValidBST(root.left)) {
            return false;
        }
        if (preVal >= root.val) {
            return false;
        }
        preVal = root.val;
        return isValidBST(root.right);
    }
}
