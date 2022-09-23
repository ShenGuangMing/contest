package t2;

import java.util.Arrays;

public class DutchFlagQuestion {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 3, 4, 5, 2, 6, 9, 0};
//        question1(arr, 5);
        question2(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    public static void question1(int[] arr, int target) {
        int index = 0;
        int len = arr.length-1;//数组长度
        int left = -1;//左边界
        for (; index<=len; ++index) {
            if (arr[index] <= target) {
                swap(arr, index, ++left);
            }
        }
    }

    public static void question2(int[] arr, int target) {
        int index = 0;
        int left = -1;
        int right = arr.length;
        while (index < right) {
            if (arr[index] < target) {
                swap(arr, index++, ++left);
            }else if (arr[index] > target) {
                //index不能向后移，因为交换中的arr[--right]还没有看
                swap(arr, index, --right);
            }else {
                index++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
