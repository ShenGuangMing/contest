package leetcode.leetcode0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        process1(new ArrayList<>(), nums, 0);

        return res;
    }
    public void process1(List<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for(int i = index; i < nums.length; i++) {
            if((i>index && nums[i] == nums[i-1])) {
                continue;
            }
            list.add(nums[i]);
            process1(list, nums, i+1);
            list.remove(list.size() - 1);
        }

    }
}
