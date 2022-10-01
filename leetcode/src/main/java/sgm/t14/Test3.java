package sgm.t14;

import java.util.Arrays;
/*
题目：最长有效括号

链接：https://leetcode.cn/problems/longest-valid-parentheses/

要求：给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

解题核心是，）一定是与自己最近的（（没有结合的）结合的
 */

public class Test3 {
    public static int longestValidParentheses2(String s) {
        if (s.length() <= 1)
            return 0;
        char[] c = s.toCharArray();
        int[] dp = new int[c.length];
        dp[1] = (c[0] == '(' && c[1] == ')')? 2 : 0;//如果前两个是()将dp[1]设置为2
        int max = dp[1];//当前最大长度为dp[1]
        for (int i = 2; i<c.length; i++) {
            if (c[i] == '(') {//遇到“(”对应下标的dp设置为0
                dp[i] = 0;
            }else {
                //下面的条件自己画图：())、())()、()(())
                if (i-dp[i-1]-1<0 || c[i-dp[i-1]-1] == ')'){
                    dp[i] = 0;
                }else if (i-dp[i-1]-1 >=0) {
                    if (i-dp[i-1]-2 >= 0) {
                        dp[i] = dp[i-dp[i-1]-2] + 2 + dp[i-1];
                    }else {
                        dp[i] = dp[i-1]+2;
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public static int longestValidParentheses1(String s) {
        if(s.length() <= 1)     return 0;
        char[] chars = s.toCharArray();
        //dp[i] means from s[0...i] 有效括号, 包含s[i]
        int[] dp = new int[chars.length];
        dp[1] = chars[0] == '(' && chars[1] == ')' ? 2 : 0;
        int max = dp[1];
        for(int i = 2; i < chars.length; i++)
        {
            if(chars[i] == '(')     dp[i] = 0;
            else
            {
                if(chars[i-1] == '(')
                    dp[i] = dp[i-2] + 2;

                else
                {
                    if(i - dp[i-1] - 1 < 0 || chars[i - dp[i-1] -1] == ')')
                        dp[i] = 0;
                    else
                        dp[i] = i - dp[i-1] - 1 >= 1 ?  2 + dp[i-1] + dp[i - dp[i-1] - 2]: 2 + dp[i-1];
                }
            }

            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses1(s));
        System.out.println(longestValidParentheses2(s));
    }
}
