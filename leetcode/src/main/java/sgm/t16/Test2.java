package sgm.t16;

import sgm.util.ArrayUtil;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
//        int[] arr = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length <= 2) {
            return nums.length;
        }
        int len = 2;
        boolean equal = nums[0] == nums[1] ;
        //0,0,1,1,1,1,2,3,3
        for (int i = 2; i < nums.length; i++) {
            if (!(equal && nums[i] == nums[i-1])){
                equal = nums[i] == nums[i - 1];
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
