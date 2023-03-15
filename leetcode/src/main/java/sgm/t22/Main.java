package sgm.t22;

import sgm.entity.TreeNode;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

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
