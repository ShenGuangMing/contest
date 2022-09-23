package t1;

import java.util.Arrays;

import static t2.Merge.mergeSort;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 4, 9};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    //选择排序
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            //最小值的下标
            int minIndex = i;
            for (int j = i +1; j < arr.length; j++) { //与后面的数据比较找最小的下标
                minIndex = arr[minIndex] > arr[j]? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j ++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, i, i+1);
                }
            }
        }
    }
    //插入排序
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j+1] < arr[j]; j--) {//当前的数比它前一个数小，就进行交换
                swap(arr, j+1, j);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


}
