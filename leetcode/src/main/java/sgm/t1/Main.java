package sgm.t1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{3,2,4};
        for (int i : main.twoSum(nums, 6)) {
            System.out.println(i);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //map中是否有 target - nums[i]的值，有就结束返回
            if (map.containsKey(target-nums[i]))
                //i是本次循环的数组下标，mao.get()的结果是（target - nums[i]）的下标
                return new int[]{i, map.get(target-nums[i])};
            //这样添加还有去重的作用
            map.put(nums[i], i);
        }
        return null;
    }
}
