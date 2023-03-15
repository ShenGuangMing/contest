package sgm.t19;

import sgm.util.ArrayUtil;

/*
* link:https://leetcode.cn/problems/unique-paths/
*
*
* */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        return process2(m, n, new int[m][n]);
    }
    public static int process2(int m, int n, int[][] dp) {
        for (int i = 0; i < n; i++) {
            dp[m-1][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][n-1] = 1;
        }
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >=0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    public static int process1(int curM, int curN, int m, int n) {
        if (curM == m && curN == n) {//走到终点
            return 1;
        }
        if (curM == m) {//走到下边界
            return process1(curM, curN+1, m, n);
        }
        if (curN == n) {//走到有边界
            return process1(curM+1, curN, m, n);
        }
        int sum = 0;//两种情况总和
        sum += process1(curM+1, curN, m, n);
        sum += process1(curM, curN+1, m, n);
        return sum;
    }

}
