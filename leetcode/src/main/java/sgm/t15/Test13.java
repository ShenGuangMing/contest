package sgm.t15;

import sgm.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
/*
题目：插入区间

链接：https://leetcode.cn/problems/insert-interval/

要求：给你一个 无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

 */
public class Test13 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 5}};
        int[][] res = insert1(arr, new int[]{2, 3});
        ArrayUtil.print2Arr(res, res.length, res[0].length);
    }

    public static int[][] insert1(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> list = new ArrayList<>();
        boolean isAdd = false;
        for (int[] arr : intervals) {
            if (arr[0] > right) {//插入区间右侧无交集
                if (!isAdd) {
                    list.add(new int[]{left, right});//使用合并后的left和right
                    isAdd = true;//标识
                }
                list.add(arr);//
            }else if (arr[1] < left) {//插入区间的左侧无交集
                list.add(arr);
            }else {//左侧没有，右侧没有，那就只能是中间了
                //成为新的插入区间
                left = Math.min(left, arr[0]);
                right = Math.max(right, arr[1]);
            }
        }
        if (!isAdd){
            list.add(new int[]{left, right});
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if ( intervals == null || intervals.length == 0||intervals[0] == null || intervals[0].length == 0) {
            return new int[][]{newInterval};
        }
        int left = newInterval[0];
        int right = newInterval[1];
        boolean isAdd = false;
        int index = 0;
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 0; i < intervals.length; i++) {
            int prevStart = intervals[index][0];
            int prevEnd = intervals[index][1];
            if (!isAdd && prevEnd >= left && prevStart<=right) {
                prevStart = Math.min(prevStart, left);
                prevEnd = Math.max(right, prevEnd);
                intervals[index][0] = prevStart;
                intervals[index][1] = prevEnd;
                isAdd = true;
            }
            if (prevEnd >= intervals[i][0] ) {
                prevEnd = Math.max(prevEnd, intervals[i][1]);
                intervals[index][0] = prevStart;
                intervals[index][1] = prevEnd;
            }else {
                int curStart = intervals[i][0];
                int curEnd = intervals[i][1];
                if (!isAdd &&  curEnd>= left && curStart<= right)  {
                    curStart = Math.min(curStart, left);
                    curEnd = Math.max(curStart, right);
                    isAdd = true;
                }else if (curStart > right && prevEnd<left){
                       list.add(newInterval);
                       isAdd = true;
                }
                index++;
                intervals[index][0] = curStart;
                intervals[index][1] = curEnd;
                list.add(intervals[index]);
            }
        }
        if (!isAdd) {
            list.add(newInterval);
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }
}
