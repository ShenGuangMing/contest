package sgm.t15;

import sgm.util.ArrayUtil;

import java.util.Arrays;
/*
题目：合并区间

链接：https://leetcode.cn/problems/merge-intervals/submissions/

要求：以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

 */
public class Test12 {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(arr);
        System.out.println();
        ArrayUtil.print2Arr(merge, merge.length, merge[0].length);
    }

    public static int[][] merge(int[][] intervals) {

        //排序
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);

        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[index][0];
            int curEnd = intervals[index][1];
            if (curEnd >= intervals[i][0] ) {
                curEnd = Math.max(curEnd, intervals[i][1]);
                intervals[index][0] = curStart;
                intervals[index][1] = curEnd;
            }else {
                index++;
                intervals[index][0] = intervals[i][0];
                intervals[index][1] = intervals[i][1];
            }
        }
        return Arrays.copyOf(intervals,  index+1);
    }
}
