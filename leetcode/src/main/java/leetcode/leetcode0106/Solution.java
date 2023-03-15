package leetcode.leetcode0106;

import sgm.entity.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
    private int[] inorder;
    private int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return process(inorder.length-1, 0, inorder.length-1);
    }
    public TreeNode process(int index, int left, int right) {
        if (left == right) {
            return new TreeNode(inorder[left]);
        }
        for (int i = left; i<=right; i++) {
            if (postorder[index] == inorder[i]) {
                TreeNode node = new TreeNode(postorder[index]);
                node.left = process(index-(right-i+1), left, i-1);
                node.right = process(index-1, i+1, right);
                return node;
            }
        }
        return null;
    }



}
