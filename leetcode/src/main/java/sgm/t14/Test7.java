package sgm.t14;

import java.util.Arrays;
/*
题目：跳跃游戏||

链接：https://leetcode.cn/problems/jump-game-ii/

要求：给你一个非负整数数组 nums ，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

假设你总是可以到达数组的最后一个位置。
 */
public class Test7 {
    public static void main(String[] args) {
        int[] nums = {1,2,0,1,1,4,0,0,0};
        Test7 t = new Test7();
        System.out.println(t.jump(nums));
        System.out.println(jump2(nums));
        System.out.println(jump3(nums));

    }
    // copy的别人的最优解
    public int jump(int[] nums) {
        int end = 0;
        int max = 0;
        int res = 0;
        for (int i = 0; i < nums.length-1; i++) {//i从头跳到未
            max = Math.max(max, i + nums[i]);//跟新每一次能跳到最大位置
            if (i == end) {//如果i等于了最大位置 就把end更新并且res++;
                end = max;
                res++;
            }
        }
        return res;
    }

    //dp
    public static int jump3(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[N-1] = 0;//边界设值0，因为到终点不需要走了
        for (int i = N-2; i>=0; i--) {
            int min = 10000;//设置的最小步数
            for (int j = 0; j < nums[i]; j++) {//能走的范围
                int index = i+j+1;//这一步能走的下标能到哪里
                int n = 0;
                if (index < N-1) {//这一步走不到终点
                    n = 1+dp[index];//
                }else {
                    min = 1;//能走到终点就只需要一步了
                    break;
                }
                min = Math.min(min, n);//这一步能走的范围中，花的最小步数
            }
            dp[i] = min;
        }
        return dp[0];
    }
    //递归加傻缓存
    public static int jump2(int[] nums) {
        int[] dp = new int[nums.length];
        int res = process2(nums, 0, dp);
        System.out.println(Arrays.toString(dp));
        return res;
    }
    public static int process2(int[] nums, int cur, int[] dp) {
        if (cur >= nums.length-1) {
            dp[nums.length-1] = 0;
            return 0;
        }
        if (dp[cur] != 0) {
            return dp[cur];
        }
        int min = 100;
        int n = 0;
        for (int i = 0; i < nums[cur]; i++) {
            n = 1+process2(nums, cur+(i+1), dp);
            min = Math.min(n, min);
        }
        dp[cur] = min;
        return min;
    }
    //递归
    public static int jump1(int[] nums) {
        return process1(nums, 0);
    }

    public static int process1(int[] nums,int cur) {
        if (cur >= nums.length-1)
            return 0;
        int min = Integer.MAX_VALUE;
        int n = 0;
        for (int i = 0; i < nums[cur]; i++) {
            n = 1+process1(nums, cur+(i+1));
            min = Math.min(n, min);
        }
        return min;
    }
}
