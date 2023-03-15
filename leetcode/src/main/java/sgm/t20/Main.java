package sgm.t20;

import sgm.util.ArrayUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.uniquePathsWithObstacles(new int[][]{{0}}));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return process2(obstacleGrid);
    }
    public static int process2(int[][] arr) {
        if (arr[0][0] == 1) {
            return 0;
        }
        int m = arr.length;
        int n = arr[0].length;
        for (int i = m-1; i >= 0; i--) {
            if (arr[i][n-1] == 1) {
                break;
            }
            arr[i][n-1] = -1;
        }
        for (int i = n-1; i >= 0; i--) {
            if (arr[m-1][i] == 1) {
                break;
            }
            arr[m-1][i] = -1;
        }
        for (int i=m-2; i>=0; i--) {
            for (int j=n-2; j>=0; j--) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] += arr[i][j+1]==1?0:arr[i][j+1];
                arr[i][j] += arr[i+1][j]==1?0:arr[i+1][j];
            }
        }
        return -arr[0][0];
    }

    public static int process1(int[][] arr, int m, int n) {
        if (m == arr.length-1 && n == arr[0].length-1) {
            return 1;
        }
        if (arr[m][n] == 1) {
            return 0;
        }
        if (m == arr.length-1) {
            return process1(arr, m, n+1);
        }
        if (n == arr[0].length-1) {
            return process1(arr, m+1, n);
        }
        int sum = 0;
        sum += process1(arr, m+1, n);
        sum += process1(arr, m, n+1);
        return sum;
    }
}
