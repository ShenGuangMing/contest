package sgm.t21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* link:https://leetcode.cn/problems/permutations-ii/description/
*
*
* */
public class Main {
    public static void main(String[] args) {




    }
    private boolean[] visit;
    public List<List<Integer>> permuteUnique(int[] nums) {
        //数据标识位
        visit = new boolean[nums.length];
        //数组排序
        Arrays.sort(nums);
        //定义
        List<List<Integer>> res = new ArrayList<>();
        process1(res, new ArrayList<>(), 0, nums);
        return res;
    }
    public void process1(List<List<Integer>> res, List<Integer> temp, int index, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        for (int i=0; i<nums.length; ++i) {
            if (visit[i] || (i > 0 && nums[i] == nums[i-1] && !visit[i-1])) {
                continue;
            }
            visit[i] = true;
            temp.add(nums[i]);
            process1(res, temp, index+1, nums);
            visit[i] = false;
            temp.remove(index);
        }
    }

}
