package leetcode.leetcode0113;

import sgm.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        process(res, new ArrayList<>(), root, targetSum);
        return res;
    }
    public void process(List<List<Integer>> res, List<Integer> list, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        if (targetSum == root.val && root.left == null && root.right == null) {
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        process(res, list, root.left, targetSum-root.val);
        process(res, list, root.right, targetSum-root.val);
        list.remove(list.size()-1);
    }
}
