package t8;

/*
* link:http://lx.lanqiao.cn/problem.page?gpid=T2321
* */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (check(i))
                sum++;
        }
        System.out.println(sum);
    }
    public static boolean check(int n) {
        while (n != 0) {
            if (n % 10 == 3 || n % 10 == 7) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
