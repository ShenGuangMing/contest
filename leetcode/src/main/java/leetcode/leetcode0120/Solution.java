package leetcode.leetcode0120;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return process1(triangle);
    }
    public int process1(List<List<Integer>> res) {
        int n = res.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + res.get(i).get(j);
            }
        }
        return dp[0];
    }

    public int process(List<List<Integer>> triangle, int layer, int index, int sum) {
        if (layer == triangle.size()) {
            return sum;
        }
        int m1 = process(triangle, layer+1, index, sum + triangle.get(layer).get(index));
        int m2 = process(triangle, layer+1, index+1, sum + triangle.get(layer).get(index));
        return Math.min(m1, m2);
    }
}
