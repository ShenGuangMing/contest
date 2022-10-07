package sgm.t15;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};

        System.out.println(method1(arr));
    }

    public static List<List<Integer>> method1(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[arr.length];
        process1(res, arr, new ArrayList<>(), visited);
        return res;
    }
    public static void process1(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            process1(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }



    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        return null;
    }
}
