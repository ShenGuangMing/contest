package sgm.t13;
/*
题目：判定是否互为字符重排

链接：https://leetcode.cn/problems/check-permutation-lcci/

要求：给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */
public class Test5 {
    public static void main(String[] args) {

    }
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int sum1 = Integer.MIN_VALUE;
        int sum2 = 0;
        int sum3 = Integer.MIN_VALUE;
        int sum4 = 0;
        for (int i = 0; i < s1.length(); i++) {
            sum1 += s1.charAt(i);
            sum2 ^= s1.charAt(i);
            sum3 += s2.charAt(i);
            sum4 ^= s2.charAt(i);

        }
        return sum1 == sum3 && sum2 == sum4;
    }
}
