package t7_dp;

import util.StrUtil;
import util.Time;

import java.util.Arrays;

public class Code4_ {
    public static int method3(String s) {
        Time.start();
        char[] c = s.toCharArray();
        int N=c.length;
        int[] dp = new int[N+1];
        dp[N] = 1;
        for (int i = N-1; i>=0; i--) {
            if (c[i] != '0') {
                int sum = 0;
                sum += dp[i+1];
                if (i+1< c.length && ( (c[i] == '1') || (c[i] == '2' && c[i+1] <= '6' ) ) ) {
                    sum += dp[i+2];
                }
                dp[i] = sum;
            }

        }
        Time.end("method3");
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static int method2(String s) {
        Time.start();
        char[] c = s.toCharArray();
        int[] dp = new int[c.length+1];
        Arrays.fill(dp, -1);
        int res = process2(c, 0, dp);
        Time.end("method2");
        System.out.println(Arrays.toString(dp));
        return res;
    }

    public static int process2(char[] c, int index, int[] dp) {
        if (index == c.length) {//越界说明找到了一种有效解，如305就不会到递归到越界，30就返回0了
            dp[index] = 1;
            return 1;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        if (c[index] == '0') {
            dp[index] = 0;
            return 0;
        }
        int sum = 0;
        sum += process2(c, index+1, dp);
        //当存在下一个，并且 (c[index] == '1') || (c[index] == '2' && c[index+1] <= '6' ) 表示 c[index]*1+c[index+1] <= 26才行
        if (index+1< c.length && ( (c[index] == '1') || (c[index] == '2' && c[index+1] <= '6' ) ) ) {
            sum += process2(c, index+2, dp);
        }
        dp[index] = sum;
        return sum;
    }


    public static int method1(String s) {
        Time.start();
        int res = process1(s.toCharArray(), 0);
        Time.end("method1");
        return res;
    }

    public static int process1(char[] c, int index) {
        if (index == c.length){
            return 1;//越界返回1
        }
        if (c[index] == '0') {//零不应该单独出现，说明上一步的决策有误
            return 0;
        }
        int sum = 0;
        sum += process1(c, index+1);
        //当存在下一个，并且 (c[index] == '1') || (c[index] == '2' && c[index+1] <= '6' ) 表示 c[index]*1+c[index+1] <= 26才行
        if (index+1< c.length && ( (c[index] == '1') || (c[index] == '2' && c[index+1] <= '6' ) ) ) {
            sum += process1(c, index+2);
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "72102312312320312031";
        System.out.println(method1(s));
        System.out.println(method2(s));
        System.out.println(method3(s));
    }
}
