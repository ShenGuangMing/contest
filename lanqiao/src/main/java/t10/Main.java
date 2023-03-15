package t10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long sum = Integer.MIN_VALUE;
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int inputNum = scan.nextInt();
            sum = Math.max(inputNum, sum + inputNum);
            max = Math.max(max, sum);
        }
        System.out.println(sum);
    }
}
