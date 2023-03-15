package t3;

import java.math.BigInteger;
import java.util.Scanner;

/*
* link:http://lx.lanqiao.cn/problem.page?gpid=T2495
* */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger n = scan.nextBigInteger();
        BigInteger p = scan.nextBigInteger();
        BigInteger num = new BigInteger("1");
        BigInteger x = new BigInteger("1");
        while(n.intValue() > 0) {
            num = num.multiply(n);
            n = n.subtract(x);
        }
        System.out.println(num.mod(p));
    }
}
