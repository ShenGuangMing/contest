package leetcode.leetcode0118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (List<Integer> integers : solution.generate(6)) {
            for (Integer integer : integers) {
                System.out.printf("%4d", integer);
            }
            System.out.println();
        }

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i+1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                    continue;
                }
                list.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
            }
            res.add(list);
        }
        return res;
    }
}
