package t5;

import java.util.Scanner;
/*
* link:https://blog.csdn.net/qq_62219631/article/details/124931638
*
* */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            num += arr[i];
        }
        //计算平均值
        num = num / n;
        int money = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != num) {
                arr[i+1] += (arr[i] - num);
                money += Math.abs(arr[i] - num);
                arr[i] = num;
            }
        }
        System.out.println(money);
    }
}
