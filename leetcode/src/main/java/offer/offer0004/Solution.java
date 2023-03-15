package offer.offer0004;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(10*10*10*10+1);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

}
