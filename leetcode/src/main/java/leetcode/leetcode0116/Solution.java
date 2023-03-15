package leetcode.leetcode0116;

import sgm.entity.Node;
import sgm.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }
    public Node connect(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node l = queue.poll(), r;
            if (l.left != null)
                queue.add(l.left);
            if (l.right != null) {
                queue.add(l.right);
            }
            for (int i = 1; i < size; i++) {
                r = queue.poll();
                l.next = r;
                l = r;
                if (r.left != null)
                    queue.add(r.left);
                if (r.right != null) {
                    queue.add(r.right);
                }
            }
        }
        return root;
    }


}
