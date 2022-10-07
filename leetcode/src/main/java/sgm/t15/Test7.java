package sgm.t15;

import sgm.t3.Main;

public class Test7 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1,0,-2,2}));
    }
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int n = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= 0) {
                break;
            }
            max = Math.max(max, num);
            n++;
        }
        if (n == len)
            return max;
        int sum = 0;
        for (int i = n; i < len; i++) {

            if (sum <  0) {
                sum = nums[i];
            }else {
                sum+=nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
