package sgm.t14;

import sgm.util.ArrayUtil;

import java.util.*;
/*
题目：零矩阵

链接：https://leetcode.cn/problems/zero-matrix-lcci/

要求：编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 t = new Test2();
        Scanner scanner = new Scanner(System.in);
        int[][] arr = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
        };
        t.setZeroes(arr);
        ArrayUtil.print2Arr(arr, 3, 3);
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        for (int i = 0; i< matrix.length; i++) {
            for (int j = 0; j< matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    col.add(j);
                    row.add(i);
                }
            }
        }
        for (int i = 0; i< matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (col.contains(j) || row.contains(i)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        boolean[] col = new boolean[matrix[0].length];
        boolean[] row = new boolean[matrix.length];
        for (int i = 0; i< matrix.length; i++) {
            for (int j = 0; j< matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    col[j] = row[i] = true;
                }
            }
        }
        for (int i = 0; i< matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (col[j] || row[i]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
