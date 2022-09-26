import org.junit.Test;

public class TT {
    @Test
    public void test1() {
        double res = 1.0;
        long l = 1L;
        long n = 13;
        for (int i = 0; i < 4; i++) {
            l *= n--;
        }
        System.out.println(l);
    }


}
