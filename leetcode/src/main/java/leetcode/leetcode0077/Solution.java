package leetcode.leetcode0077;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (List<Integer> integers : solution.combine(4, 2)) {
            System.out.println(integers);
        }

    }
    private int n, k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        List<List<Integer>> res = new ArrayList<>();
        process1(res, new ArrayList<>(), 1);
        return res;
    }
    public void process1(List<List<Integer>> res, List<Integer> list, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            process1(res, list, ++start);
            list.remove(list.size()-1);
        }
    }
}
