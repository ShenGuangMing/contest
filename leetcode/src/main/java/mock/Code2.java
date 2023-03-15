package mock;


public class Code2 {
    public static void main(String[] args) {
        int n = 2022;
        StringBuilder sb= new StringBuilder();
        while (n != 0) {
            sb.append((char) (65 + (n%26)));
            n/=26;
        }
        System.out.println(sb.reverse());
    }
}
