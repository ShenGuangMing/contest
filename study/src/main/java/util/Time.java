package util;

public class Time {
    private static long start = 0;
    private static long end = 0;
    public static void start() {
        start = System.nanoTime();
    }
    public static void end(String s) {
        end = System.nanoTime();
        long time = end - start;
        System.out.println(s + "耗时：" + time);
    }
}
