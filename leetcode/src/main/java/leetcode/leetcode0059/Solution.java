package leetcode.leetcode0059;

import sgm.util.ArrayUtil;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] res = s.generateMatrix(4);
        ArrayUtil.print2Arr(res);
    }
    public int[][] generateMatrix(int n) {
        int t = 0, b = n-1, l = 0, r = n-1, num = 1;
        int[][] res = new int[n][n];
        int step = n*n;
        while (num <= step) {
            for (int i = l; i <= r; i++)
                res[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) {
                res[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--)
                res[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) {
                res[i][l] = num++;
            }
            l++;
        }
        return res;
    }
}
