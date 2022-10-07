package t12_Manacher;

import java.util.Arrays;

public class Code1_ {
    public static void main(String[] args) {
        longestPalindrome("sgmsgm");
    }
    public static String longestPalindrome(String s) {
        manacher(s.toCharArray());
        return "";
    }
    public static void manacher(char[] s) {
        int len = s.length*2+1;
        char[] str = new char[len];
        int[] mark = new int[len];
        for (int i = 0; i< s.length; i++) {
            str[i*2+1] = s[i];
        }
        int R = -1;
        int C = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<len; i++) {
            mark[i] = R > i ? Math.min(mark[2*C-i], R-i) : 1;
            while (i+mark[i] < str.length && i-mark[i] > -1){
                if (str[i+mark[i]] == str[i - mark[i]]) {
                    mark[i]++;
                }else{
                    break;
                }
            }
            if (i + mark[i] > R) {
                R = i + mark[i];
                C = i;
            }
            max = Math.max(max, mark[i]);
        }
        
    }
}
