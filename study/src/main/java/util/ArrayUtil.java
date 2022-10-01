package util;

public class ArrayUtil {

    public static void print2Arr(int[][] arr, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (arr[i][j] == -1) {
                    System.out.printf("%-5d", 0);
                }else
                    System.out.printf("%-5d", arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void print2Arr2(int[][] arr1, int[][] arr2, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (arr1[i][j] == -1) {
                    System.out.printf("%-5d", 0);
                }else
                    System.out.printf("%-5d", arr1[i][j]);
            }
            System.out.print("\t\t\t");
            for (int j = 0; j < y; j++) {
                if (arr2[i][j] == -1) {
                    System.out.printf("%-5d", 0);
                }else
                    System.out.printf("%-5d", arr2[i][j]);
            }
            System.out.println();
        }
    }
}
