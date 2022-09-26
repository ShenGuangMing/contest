package util;

public class Permutations {
    public static void main(String[] args) {
        double all = method1(52, 4);
        double m = method1(13, 4);
        System.out.println("result: "+m/all*4);
    }
    public static double method1(int m, int n) { // Cm n 问题
        long fenZi = 1;
        long fenMu = 1;
        int count = n;
        for (int i = 0; i < count; i++) {
            fenZi*=m--;
            fenMu*=n--;
        }
        return fenZi/(fenMu*1.0);
    }
}
