package mock;

public class Code1 {
    public static void main(String[] args) {
        int n = 2022;
        boolean is = false;//标记是否含有0~9数字
        while (true) {
            is = false;//每个数默认不含有
            String s = toBinary(++n);//十进制 -> 二进制
            String hex = binaryToHex(s);//二进制 -> 十六进制
            for (int i = 0; i<=9; i++) {
                if (hex.contains(i+"")) {//如果含有
                    is = true;//修改标记为有
                    break;//退出
                }
            }
            if (!is) {
                System.out.println(hex);//找到一个就退出
                break;
            }
        }

    }

    public static String toBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 2);
            n/=2;
        }
        int len = sb.length();
        if (len % 4 == 0) {
            return sb.reverse().toString();
        }
        for (int i = 1; i <= (4 - len%4); i++){
            sb.append(0);
        }
        return sb.reverse().toString();
    }
    public static String binaryToHex(String binary) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < binary.length()) {
            String subStr = binary.substring(index, index + 4);
            sb.append(dictionary(subStr));
            index += 4;
        }
        return sb.toString();
    }
    public static char dictionary(String s) {
        int base = 8;
        int res = 0;
        for (char c : s.toCharArray()) {
            res += base * (c - '0');
            base /= 2;
        }
        if (res < 10) {
            return (char) ('0' + res);
        }
        return (char) (65+res-10);
    }
}
