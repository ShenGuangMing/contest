import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Sub extends Sup{
    public int i = 44;

    @Override
    public void method1() {
        System.out.println("Sub");
    }
    public static void main(String[] args) {
        Sup sup = new Sub();
        System.out.println(sup.i);
        sup.method1();
        List<String> list = new ArrayList<>();
        for (String s : list) {

        }

    }
}

class Sup {
    public int i = 20;

    public void method1() {
        System.out.println("Sup");
    }
}
