package sgm.t24;
/*
* link:https://leetcode.cn/problems/longest-common-subsequence/description/
* */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.longestCommonSubsequence("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq"));
    }
    char[] t1, t2;
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        t1 = text1.toCharArray();
        t2 = text2.toCharArray();
        dp = new int[t1.length+1][t2.length+1];
        return process2(dp);
    }
    public int process2(int[][] dp) {
        int i=0, j=0;
        for (i=1; i<dp.length; i++) {
            for (j=1; j<dp[0].length; j++) {
                if (t1[i-1] == t2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[i-1][j-1];
    }

    public int process1(int i, int j) {
        if (i<0 || j<0) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int n;
        if (t1[i] == t2[j]) {
            n = process1(i - 1, j - 1) + 1;
        }else {
            n = Math.max(process1(i, j - 1), process1(i - 1, j));
        }
        dp[i][j] = n;
        return n;
    }
}
