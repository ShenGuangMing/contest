package leetcode.leetcode0114;

import sgm.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public void flatten(TreeNode root) {
        Queue<TreeNode> deque = new ArrayDeque<>();
        process(deque, root);
        TreeNode head = deque.poll(), node = head;
        System.out.println(deque.size());
        while (!deque.isEmpty()) {
            node.right = deque.poll();
            node.left = null;
            node = node.right;
        }
    }
    public void process(Queue<TreeNode> deque, TreeNode node) {
        if (node == null)
            return;
        deque.add(node);
        process(deque, node.left);
        process(deque, node.right);
    }



}
