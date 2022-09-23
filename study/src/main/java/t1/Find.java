package t1;

public class Find {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 4, 9};
//        int[] arr = {5, 5, 5, 5, 5};
//        int[] arr = {1, 5, 5, 7, 11, 11, 11, 12, 21, 21, 32, 33, 33, 40, 40, 40, 41};
        int i = dichotomyCycle(arr, 48);
//        if (i != -1) {
//            System.out.println(i + " : " + arr[i]);
//        }else {
//            System.out.println("null");
//        }
//
//        i = dichotomyRecursion(arr, 0, arr.length-1, 11);
//        if (i != -1) {
//            System.out.println(i + " : " + arr[i]);
//        }else {
//            System.out.println("null");
//        }
//
//        i = farLeftCycle(arr, 36);
//        if (i != -1) {
//            System.out.println(i + " : " + arr[i]);
//        }else {
//            System.out.println("null");
//        }
       i = localMin(arr);
        if (i>-1) {
            System.out.println(i + " : " + arr[i]);
        }
        System.out.println(findMax(arr, 0, arr.length - 1));
    }

    public static int dichotomyCycle(int[] arr, int target) {
        int right = arr.length -1;
        int left = 0;
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] == target) {
                return mid;
            }else if (arr[mid] < target) {
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }
    public static int dichotomyRecursion(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) return  mid;
        else if (arr[mid] < target) return dichotomyRecursion(arr,  mid+1, right, target);
        else return dichotomyRecursion(arr,  left, mid-1, target);
    }

    public static int farLeftCycle(int[] arr, int target) {
        int right = arr.length -1;
        int left = 0;
        int mid = (left + right) / 2;
        while (left < right) {
            if (arr[mid] < target) {
                left = mid + 1;
            }else  {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        if (arr[mid] < target) {
            return -1;
        }
        return mid;
    }

    //在无重复元素，无序数组中找局部最小
    public static int localMin(int[] arr) {
        if (arr[0] < arr[1]) {
            return 0;
        }else if (arr[arr.length -1] < arr[arr.length -2]) {
            return arr.length -1;
        }
        int right = arr.length-1;
        int left = 0;
        while (left < right) {
            int mid = (left+right)/2;
            System.out.println(mid);
            if (mid-1>=0 && arr[mid] > arr[mid -1]) {
                right = mid;
            }else if (mid + 1 < arr.length && arr[mid] > arr[mid +1]) {
                left = mid;
            }else {
                return mid;
            }
        }
        return -1;
    }
    //递归查询最大值
    public static int findMax(int[] arr, int l, int r) {
        if (l == r)
            return arr[l];
        int mid = l +( (r - l)>>1);
        int leftMax = findMax(arr, l, mid);
        int rightMax = findMax(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

}
