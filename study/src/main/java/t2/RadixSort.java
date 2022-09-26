package t2;

public class RadixSort {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length-1, maxBits(arr));
    }

    public static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(i, max);//求数组中的最大值
        }
        int digit = 0;//最大值的位数
        while (max != 0) {
            max/=10;
            digit++;
        }
        return digit;
    }

    public static void radixSort(int[] arr, int L, int R, int digit) {

    }

}
