package sgm.t14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
题目：重复2两次的数字

链接：https://leetcode.cn/problems/two-out-of-three/

要求：给定三个数组，返回数字出现在至少两个数组中的数
 */
public class Test6 {
    public static void main(String[] args) {
        int[] n1 = {9,11,15,5};
        int[] n2 = {1,5,5,12,4,8,3,4,5,10};
        int[] n3 = {8};
        Test6 t = new Test6();
        System.out.println(t.twoOutOfThree(n1, n2, n3).toString());
    }
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            map.put(i,1);
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) == 1) {
                map.put(i, 3);
            }else if (!map.containsKey(i)){
                map.put(i, 2);
            }
        }
        for (int i : nums3) {
            if (map.containsKey(i) && map.get(i) == 3) {
                map.put(i, 6);
            }else if (map.containsKey(i) && map.get(i) == 2){
                map.put(i, 5);
            }else if (map.containsKey(i) && map.get(i) == 1){
                map.put(i, 4);
            }else if (!map.containsKey(i)) {
                map.put(i, 0);
            }
        }
        for (Integer integer : map.keySet()) {
            int i = map.get(integer);
            if (i>=3) {
                list.add(integer);
            }
        }
        return list;
    }
}
