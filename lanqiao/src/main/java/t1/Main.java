package t1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startYear = scan.nextInt();
        int startHeight = scan.nextInt();
        for (int i = startYear; i < 2013; i++) {
            if (i % 400 == 0 || (i % 100 != 0 && i % 4 == 0)) {
                startHeight += 366;
            }else {
                startHeight += 365;
            }
        }
        System.out.println(startHeight);
    }
}
