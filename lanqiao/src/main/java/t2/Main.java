package t2;

import java.util.Scanner;

/*
* link:http://lx.lanqiao.cn/problem.page?gpid=T2430
* parse:https://blog.csdn.net/m0_57100760/article/details/123078595
* */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int result = 0;
        int k = n - 1;
        for (int i = 2; i <= n; i++, k--) {
            result = (result + k) % i;
        }
        System.out.println(result + 1);
    }
}
