package sgm.t16;

import java.util.ArrayList;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subsets(arr));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubs = new ArrayList<>();
            for (List<Integer> sub : res) {
                List<Integer> newSub = new ArrayList<>(sub);
                newSub.add(num);
                newSubs.add(newSub);
            }
            res.addAll(newSubs);
        }
        return res;
    }
}
