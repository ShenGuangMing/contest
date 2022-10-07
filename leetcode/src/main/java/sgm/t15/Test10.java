package sgm.t15;

public class Test10 {
    public static void main(String[] args) {
        System.out.println(checkOnesSegment("10"));
    }

    public static boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
