package sgm.t14;

import java.util.PriorityQueue;

/*
题目：第K个数

链接：https://leetcode.cn/problems/get-kth-magic-number-lcci/

要求：有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，
而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。

 */
public class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        System.out.println(t.getKthMagicNumber(8));
    }
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k+1];
        dp[1] = 1;
        int p3 = 1,p5=1,p7=1;
        for (int i = 2; i<= k; i++) {
            int num3=dp[p3]*3,num5=dp[p5]*5,num7=dp[p7]*7;
            dp[i] = Math.min(num3, Math.min(num5, num7));
            if (num3 == dp[i])
                p3++;
            if (num5 == dp[i])
                p5++;
            if (num7 == dp[i])
                p7++;
        }
        return dp[k];
    }
}
