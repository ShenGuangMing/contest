import entity.Student;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    @Test
    public void test1() {
        Student s1 = new Student(1, "smg");
        Student s2 = new Student(2, "SGMing");
        Student s3 = new Student(3, "yy");
        Map<Integer, Student> map = new HashMap<>();
        map.put(1, s1);
        map.put(2, s2);
        map.put(3, s3);
        s1.setName("sgm");
        System.out.println(map.get(1));
    }
}
