package t4;

import java.util.Scanner;

/*
* link:https://blog.csdn.net/m0_52066789/article/details/123783283
* 思路：
* 从1开始，我们考虑它在每个D(i)中的使用次数 ，如果n是10000000，那么1出现的次数就是 n/1.
                                                          2对应的就是  n/2 次
                                                          3出现的次数 n/3
* */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += n/i % 1000000007;
        }
        System.out.println(sum % 1000000007);
    }
}
