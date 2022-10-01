package t7_dp;

/*
1-N个数，一个机器人再start（1-N中任意一个）的位置，他走step步到aim的方法有多少种
 */

import util.Time;

public class Code1_RobotWalk {
    /**
     *
     * @param N     1-N个数
     * @param step  一共有多少步
     * @param start 开始位置
     * @param aim   目标位置
     * @return 从start走step步数到aim共有所有种方法
     */
    public static int getWays3(int N, int step, int start, int aim) {
        Time.start();
        int[][]dp = new int[N+1][step+1];
        dp[aim][0] = 1;
        for (int rest = 1; rest <= step; rest ++) {
            dp[1][rest] = dp[2][rest-1];
            for (int cur = 2; cur<N; cur ++) {
                dp[cur][rest] = dp[cur-1][rest-1] + dp[cur+1][rest-1];
            }
            dp[N][rest] = dp[N-1][rest-1];
        }
        Time.end("getWays3");
        return dp[start][step];
    }

    /**
     *
     * @param N     1-N个数
     * @param step  一共有多少步
     * @param start 开始位置
     * @param aim   目标位置
     * @return 从start走step步数到aim共有所有种方法
     */
    public static int getWays2(int N, int step, int start, int aim) {
        long s = System.nanoTime();
        int[][] dp = new int[N + 1][step + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= step; j++) {
                dp[i][j] = -1;
            }
        }
        long e = System.nanoTime();
        int res = process2(start, step, aim, N, dp);
        System.out.println("getWays2 time: " + (e - s));
        return res;
    }

    public static int process2(int cur, int rest, int aim, int N, int[][] dp) {
        if (dp[cur][rest] != -1) {//中缓存了
            return dp[cur][rest];
        }
        //没中缓存需要计算
        int ans = 0;
        if (rest == 0) {
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = process2(2, rest - 1, aim, N, dp);
        } else if (cur == N) {
            ans = process2(N - 1, rest - 1, aim, N, dp);
        } else {
            ans = process2(cur - 1, rest - 1, aim, N, dp) + process2(cur + 1, rest - 1, aim, N, dp);
        }
        dp[cur][rest] = ans;//记缓存
        return ans;
    }

    public static int getWays1(int N, int step, int start, int aim) {
        long s = System.nanoTime();
        int res = process1(start, step, aim, N);
        long e = System.nanoTime();
        System.out.println("getWays1 time: " + (e - s));
        return res;
    }


    /**
     * @param cur  当前位置
     * @param rest 还剩多少步
     * @param aim  目标位置
     * @param N    1-N的数
     * @return 多少种方法
     */
    public static int process1(int cur, int rest, int aim, int N) {
        if (rest == 0) { //走完了
            return aim == cur ? 1 : 0;
        }
        int sum = 0;
        if (cur == 1) {//当前在边界位置只能向右走
            sum += process1(2, rest - 1, aim, N);
        } else if (cur == N) {//当前在边界位置只能向左走
            sum += process1(N - 1, rest - 1, aim, N);
        } else {//其他就是两边都可以走
            sum += process1(cur + 1, rest - 1, aim, N);
            sum += process1(cur - 1, rest - 1, aim, N);
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(getWays1(20, 20, 2, 4));
        System.out.println(getWays2(5, 6, 2, 4));
        System.out.println(getWays3(5, 6, 2, 4));
    }
}
