package t12_Manacher;

import java.util.Arrays;

public class Code1_ {
    public static void main(String[] args) {
        longestPalindrome("cabacabasabac");
    }
    public static String longestPalindrome(String s) {
        System.out.println(manacher(s.toCharArray()));
        return "";
    }
    public static int manacher(char[] s) {
        int len = s.length * 2 + 1;
        char[] str = new char[len];
        int[] mark = new int[len];
        for (int i = 0; i < s.length; i++) {
            str[i * 2 + 1] = s[i];
        }
        int R = -1, C = -1, max = 0;
        for (int i = 0; i < len; i++) {
            mark[i] = i < R ? Math.min(mark[2*C-i], R-i) : 1;//至少不用扩的距离
            while (i+mark[i] < len && i-mark[i] >= 0) {
                if (str[i+mark[i]] == str[i-mark[i]]) {
                    mark[i]++;
                }else {
                    break;
                }
            }
            //更新R和C
            if (i+mark[i] > R) {
                R = i+mark[i];
                C = i;
            }
            max = Math.max(max, mark[i]);
        }
        return max-1;
    }
}
