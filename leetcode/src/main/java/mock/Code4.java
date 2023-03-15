package mock;

public class Code4 {
    public static void main(String[] args) {
        int[] arr = {99, 22, 51, 63, 72, 61, 20, 88, 40, 21, 63, 30, 11, 18, 99, 12, 93, 16, 7, 53, 64, 9, 28, 84, 34, 96, 52, 82, 51, 77 };
        int count = 0;
        int all = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]*arr[j] > 2022) {
                    count++;
                }
                all++;
            }
        }
        System.out.println(all);
        System.out.println(count);
    }
}
