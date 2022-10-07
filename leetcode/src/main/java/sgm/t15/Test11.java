package sgm.t15;
/*
题目：螺旋矩阵

链接：https://leetcode.cn/problems/spiral-matrix/

要求：给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

 */

import java.util.ArrayList;
import java.util.List;

public class Test11 {

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
        };
        System.out.println(spiralOrder(arr));

    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int left = 0, right = matrix[0].length-1, top = 0, bottom = matrix.length-1;
        while (left<=right && top <= bottom) {
            for (int i = left; i<=right; i++) {
                list.add(matrix[top][i]);
            }
            for (int i = top+1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right-1; i>=left; i--) {
                    list.add(matrix[bottom][i]);
                }
                for (int i = bottom-1; i>=top+1; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }

}
