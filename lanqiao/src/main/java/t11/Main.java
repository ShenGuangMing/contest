package t11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int res = 0;
        while (n != 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }

    }
}
