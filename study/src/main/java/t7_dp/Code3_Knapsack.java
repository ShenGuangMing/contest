package t7_dp;

import util.ArrayUtil;

public class Code3_Knapsack {

    /**
     * 这个dp是从下到上，从左到右进行
     * @param w 重量表
     * @param v 价值表
     * @param space 背包空间
     * @return 背包能装的最大价值
     */
    public static int maxValue3(int[] w, int[] v, int space) {
        int N = v.length;
        int[][] map = new int[N][space + 1];
        for (int s = 0; s< space+1; s++) {//最后一行填充
            if (s >= w[N-1]) {//背包剩余空间大于等于质量就赋值
                map[N-1][s] = v[N-1];
            }
        }
        for (int i = N-2; i>=0; i--) {//其他列，反序填表
            for (int s = 0; s< space+1; s++) {//从做到右
                int p1=0, p2=0; // 一个是装的总价值，一个是不装的总价值
                if (s >= w[i]) {//能装
                    p1 = v[i] + map[i+1][s-w[i]];//本次的价值+下一行背包剩余的空间的价值
                }
                p2 = map[i+1][s];//不装或装不了都会执行这个
                map[i][s] = Math.max(p1, p2);//返回装总价值和不装总价值的最大值
            }
        }
        /*
        这个填表的方式是，从左到右，每列是从下到上，不好理解
        总体就是，我依赖自己是否能装下和自己下一列左边的表数据（包括自己）
        如当前位置是i 他依赖自己是否能装下这个w[i]物品的重量和依赖自己[i+1]下一行，[(space-w[i]) ~ space]这个范围类的列的数据所以这样填表也是对的
         */
//        for (int s = 0; s<space+1 ; s++) {
//            if (s >= w[N-1]) {
//                map[N-1][s] = v[N-1];
//            }
//            for (int i = N-2; i>=0; i--) {
//                int p1=0, p2=0;
//                if (s >= w[i]) {
//                    p1 = v[i] + map[i+1][s-w[i]];
//                }
//                p2 = map[i+1][s];
//                map[i][s] = Math.max(p1, p2);
//            }
//        }
        ArrayUtil.print2Arr(map, N, space+1);
        return map[0][space];//返回最右上角
    }

    public static int maxValue2(int[] wights, int[] values, int space) {
        int[][] map = new int[values.length][space + 1];
        int res = process2(wights, values, 0, space, map);
        ArrayUtil.print2Arr(map, values.length, space + 1);
        return res;
    }

    public static int process2(int[] w, int[] v, int i, int space, int[][] map) {
        if (i == v.length || space < 0) {//背包不能装了，越界返回
            return 0;
        }
        if (map[i][space] != 0) {//中缓存
            return map[i][space];
        }
        int p1 = 0, p2 = 0;
        if (space >= w[i]) {//有足够的空间可以装
            p1 = v[i] + process2(w, v, i + 1, space - w[i], map);//选择装
        }
        //当空间不够，或现在不装
        p2 = process2(w, v, i + 1, space, map);
        int ans = Math.max(p1, p2);
        map[i][space] = ans;
        return ans;
    }


    /**
     * @param wights 重量数组
     * @param values 价值数组
     * @param space  最大容量
     * @return 能装的最大价值
     */
    public static int maxValue1(int[] wights, int[] values, int space) {
        return process1(wights, values, 0, space);
    }

    public static int process1(int[] w, int[] v, int i, int space) {
        if (i == w.length || space < 0) {
            return 0;
        }
        int p1 = 0, p2 = 0;
        if (space >= w[i]) {//有足够的空间可以装
            p1 = v[i] + process1(w, v, i + 1, space - w[i]);//选择装
        }
        p2 = process1(w, v, i + 1, space);//不装和装不下都
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        int[] w = {3, 2,  4, 7, 3, 1, 7};
        int[] v = {5, 6, 3, 19, 12, 4, 2};
//        int[] w = {1, 2, 2, 1, 3, 2, 3, 2, 1, 2};
//        int[] v = {3, 3, 5, 2, 2, 2, 4, 1, 2, 3};
        //5+3+2
        System.out.println(maxValue1(w, v, 15));
        System.out.println(maxValue2(w, v, 15));
        System.out.println(maxValue3(w, v, 15));
    }

}
