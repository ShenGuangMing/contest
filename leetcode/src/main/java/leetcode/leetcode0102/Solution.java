package leetcode.leetcode0102;

import sgm.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> dl = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            dl.add(root);
        }
        while (!dl.isEmpty()) {
            int n = dl.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i<n; i++) {
                TreeNode node = dl.poll();
                list.add(node.val);
                if (node.left != null) {
                    dl.add(node.left);
                }
                if (node.right != null) {
                    dl.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
