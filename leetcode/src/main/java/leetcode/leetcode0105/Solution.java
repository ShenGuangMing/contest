package leetcode.leetcode0105;

import sgm.entity.TreeNode;
import sgm.util.NodeUtil;

import java.sql.SQLOutput;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] preOrder = {1,3,2,4,5};
        int[] inOrder = {1,2,3,4,5};
        TreeNode head = s.buildTree(preOrder, inOrder);
        NodeUtil.printPreOrderTreeNodes(head);
        System.out.println();
        NodeUtil.printInOrderTreeNodes(head);
    }
    private int[] inorder;
    private int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        return process1(0, 0, preorder.length-1);
    }

    public TreeNode process1(int index, int l, int r) {
//        System.out.println("index=" + index + " l=" + l + " r= " + r);
        if (l == r) {
            return  new TreeNode(inorder[l]);
        }
        if (l > r) {
            return null;
        }
        TreeNode node = null;
        for (int i = l; i <= r; i++) {
            if (preorder[index] == inorder[i]) {
                node = new TreeNode(preorder[index]);
                if (index == i) {
                    node.left = null;
                    node.right = process1(index+1, i+1, r);
                }else if (i == r){
                    node.left = process1(index+1, l, i - 1);
                    node.right = null;
                }else {
                    node.left = process1(index+1, l, i - 1);
                    node.right = process1(index+i + 1-l, i + 1, r);
                }
                return node;
            }
        }
        return null;
    }


}
