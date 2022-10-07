package sgm.t15;

import sgm.util.ArrayUtil;
/*
题目：旋转图像

链接：https://leetcode.cn/problems/rotate-image/

要求：给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

 */
public class Test8 {
    public static void main(String[] args) {
        int[][] arr = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
//        int[][] arr = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        rotate(arr);
    }
    public static void rotate(int[][] matrix) {
        //先将数组上线反转
        upDownInverting(matrix, matrix.length, matrix[0].length);
        inverting(matrix, matrix.length, matrix[0].length);
    }

    public static void inverting(int[][] arr, int N, int M) {
        for (int i = 0; i< N-1; i++) {
            for (int j = i+1; j<M; j++) {
                swap(arr, i, j, j, i);
            }
        }
        System.out.println("最后结果：");
        ArrayUtil.print2Arr(arr, N, M);
    }
    public static void upDownInverting(int[][] arr, int N, int M) {
        for (int i = 0; i<N/2; i ++) {
            for (int j = 0; j<M; j++) {
                swap(arr, i, j, N-1-i, j);
            }
        }
        System.out.println("上下反转：");
        ArrayUtil.print2Arr(arr, N, M);
    }

    public static void swap(int[][] arr, int si, int sj, int ti, int tj) {
        if ((si == ti && sj == tj) || arr[si][sj] == arr[ti][tj]) {
            return;
        }
        arr[si][sj] = arr[si][sj] ^ arr[ti][tj];
        arr[ti][tj] = arr[si][sj] ^ arr[ti][tj];
        arr[si][sj]  = arr[si][sj] ^ arr[ti][tj];
    }
}
