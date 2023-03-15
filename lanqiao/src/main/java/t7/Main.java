package t7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n != 0) {
            sb.append(n % 2);
            n/=2;
        }
        System.out.println(sb.reverse().toString());
    }
}
