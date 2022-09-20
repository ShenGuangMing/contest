package t1;

public class Find {
    public static void main(String[] args) {
//        int[] arr = {5, 5, 5, 5, 5};
        int[] arr = {1, 5, 5, 7, 11, 11, 11, 12, 21, 21, 32, 33, 33, 40, 40, 40, 41};
        int i = dichotomyCycle(arr, 48);
        if (i != -1) {
            System.out.println(i + " : " + arr[i]);
        }else {
            System.out.println("null");
        }
        i = dichotomyRecursion(arr, 0, arr.length-1, 11);
        if (i != -1) {
            System.out.println(i + " : " + arr[i]);
        }else {
            System.out.println("null");
        }
        i = farLeftCycle(arr, 36);
        if (i != -1) {
            System.out.println(i + " : " + arr[i]);
        }else {
            System.out.println("null");
        }
    }

    public static int dichotomyCycle(int[] arr, int target) {
        int right = arr.length -1;
        int left = 0;
        while (left <= right) {
            int curr = (left+right)/2;
            if (arr[curr] == target) {
                return curr;
            }else if (arr[curr] < target) {
                left = curr+1;
            }else {
                right = curr -1;
            }
        }
        return -1;
    }
    public static int dichotomyRecursion(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int curr = (left + right) / 2;
        if (arr[curr] == target) return  curr;
        else if (arr[curr] < target) return dichotomyRecursion(arr,  curr+1, right, target);
        else return dichotomyRecursion(arr,  left, curr-1, target);
    }

    public static int farLeftCycle(int[] arr, int target) {
        int right = arr.length -1;
        int left = 0;
        int curr = (left + right) / 2;
        while (left < right) {
            if (arr[curr] < target) {
                left = curr + 1;
            }else  {
                right = curr;
            }
            curr = (left + right) / 2;
        }
        if (arr[curr] < target) {
            return -1;
        }
        return curr;
    }
}
