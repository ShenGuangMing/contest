package t2;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 3, 4, 5, 2, 6, 9, 6};
//        int[] arr = {1, 2, 3, 4, 5};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
            int[] p = partition(arr, left, right);
            quickSort2(arr, left, p[0]);
            quickSort2(arr, p[1], right);
        }
    }

    public static int[] partition(int[] arr, int left, int right) {
        int l = left - 1;//左区
        int r = right;//右区
        int target = arr[right];//给定范围中最后的值
        int index = left;//开始位置
        while (index < r) {//当遍历到右区就停止
            if (arr[index] < target) {
                swap(arr, index++, ++l);
            } else if (arr[index] > target) {
                swap(arr, index, --r);//荷兰国旗问题解释了
            } else {//相等的情况，index向后移
                index++;
            }
        }
        swap(arr, right, r);//和右区第一个交换
        return new int[]{l, r + 1};
    }

    public static void myQuickSort2(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int l = left - 1;
        int r = right;
        int target = arr[right];
        int index = left;
        while (index < r) {
            if (arr[index] < target) {
                swap(arr, index++, ++l);
            } else if (arr[index] > target) {
                swap(arr, index, --r);
            } else {
                index++;
            }
        }
        swap(arr, right, r);
        myQuickSort2(arr, left, l);
        myQuickSort2(arr, r, right + 1);
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
