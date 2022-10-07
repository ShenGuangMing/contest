package sgm.t15;
/*
题目：最小路径和

链接：https://leetcode.cn/problems/minimum-path-sum/

要求：给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。

 */

public class Test14 {
    public static void main(String[] args) {
        int [][] arr = new int[][] {{1, 3, 1}, {1,5,1}, {4, 2, 1}};
        System.out.println(minPathSum1(arr));
        System.out.println(minPathSum2(arr));
        System.out.println(minPathSum3(arr));
    }
    public static int minPathSum3(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[N-1][M-1] = grid[N-1][M-1];
        for (int i = N-1; i>=0; i--) {
            for (int j = M-1; j >= 0; j--) {
                int p1 = -1;
                int p2 = -1;
                if (i+1 < N) {
                    p1 = grid[i][j] + dp[i+1][j];
                }
                if (j+1 < M) {
                    p2 = grid[i][j] + dp[i][j+1];
                }
                if (p1 != -1 && p2 != -1) {
                    dp[i][j] = Math.min(p1, p2);
                }else if (p1 != -1) {
                    dp[i][j] = p1;
                }else if (p2 != -1) {
                    dp[i][j] = p2;
                }
            }
        }
        return dp[0][0];
    }


    public static int minPathSum2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return process2(grid, 0, 0, dp);
    }

    public static int process2(int[][] arr, int i, int j, int[][] dp) {
        //边界处理
        if (i<0 || i>=arr.length || j <0 || j>=arr[0].length) {
            return -1;
        }
        if (dp[i][j] != 0)
            return dp[i][j];
        if (i == arr.length-1 && j == arr[0].length-1) {
            dp[i][j] = arr[i][j];
            return arr[i][j];
        }
        int p1 = process2(arr, i + 1, j, dp);
        int p2 = process2(arr, i, j + 1, dp);
        if (p1 != -1 && p2 != -1) {
            dp[i][j] = arr[i][j] + Math.min(p1, p2);
            return dp[i][j];
        }else if (p1 == -1 && p2 != -1) {
            dp[i][j] = arr[i][j] + p2;
            return dp[i][j];
        }else if (p1 != -1 ) {
            dp[i][j] = arr[i][j] + p1;
            return dp[i][j];
        }
        return -1;
    }

    public static int minPathSum1(int[][] grid) {
        return process1(grid, 0, 0);
    }
    public static int process1(int[][] arr, int i, int j) {
        //边界处理
        if (i<0 || i>=arr.length || j <0 || j>=arr[0].length) {
            return -1;
        }
        if (i == arr.length-1 && j == arr[0].length-1) {
            return arr[i][j];
        }
        int p1 = process1(arr, i + 1, j);
        int p2 = process1(arr, i, j + 1);
        if (p1 != -1 && p2 != -1) {
            return arr[i][j] + Math.min(p1, p2);
        }else if (p1 == -1 && p2 != -1) {
            return arr[i][j] + p2;
        }else if (p1 != -1 ) {
            return arr[i][j] + p1;
        }
        return -1;
    }
}
