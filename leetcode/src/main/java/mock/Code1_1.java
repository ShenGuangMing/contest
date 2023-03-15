package mock;

import java.math.BigInteger;

public class Code1_1 {
    public static void main(String[] args) {
        boolean flag = false;//标记每个数是否是不含数字
        int n = 2022;
        while(true) {
            flag = false;//初始化，这个数不含数字0~9
            BigInteger bigInteger = BigInteger.valueOf(n);//将这个整数转化为BigInteger
            String s = bigInteger.toString(16);//通过内置方法转化为16进制
            for (char c : s.toCharArray()) {//变量每个字符是否存在数字0~9
                if (c <= '9') {//存在就标记
                    flag = true;
                    break;
                }
            }
            if (!flag) {//不存在数字0~9，就打印结束循环
                System.out.println(s);
                System.out.println(n);
                break;
            }
            n++;//存在数字就自增，进入下一个循环
        }
    }
}
