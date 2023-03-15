package leetcode.leetcode2367;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            if (set.contains(num - 2 * diff) && set.contains(num - diff))
                res++;
            set.add(num);
        }
        return res;
    }
}
