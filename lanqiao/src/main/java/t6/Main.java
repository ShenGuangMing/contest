package t6;

import java.io.*;
import java.util.Scanner;

/*
*
*
* link:http://lx.lanqiao.cn/problem.page?gpid=T1592
* */
public class Main {
    public static int count(int n) {
        String s = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '2') {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileInputStream("two.in"));
        int L = sc.nextInt();
        int R = sc.nextInt();
        int sum = 0;
        for (int i = L; i <= R; i++) {
            sum += count(i);
        }
        File out = new File("two.out");
        FileOutputStream fos = new FileOutputStream(out, false);
        fos.write((sum + "").getBytes());
    }
}