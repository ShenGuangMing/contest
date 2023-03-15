package mock;

import java.util.Scanner;

public class Code6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int start = input.nextInt();
        int step = input.nextInt();
        System.out.println((start + step)%7);
    }


}
