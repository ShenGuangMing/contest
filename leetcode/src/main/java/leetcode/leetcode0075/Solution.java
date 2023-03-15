package leetcode.leetcode0075;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 2, 2, 1, 1};
        solution.sortColors(arr);
        System.out.println(Arrays.toString(arr));


    }
    public void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;
        for (int num : nums) {
            if (0 == num) {
                redCount++;
            }else if (1 == num) {
                whiteCount++;
            }else {
                blueCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i<redCount) {
                nums[i] = 0;
            }else if (i<redCount+whiteCount) {
                nums[i] = 1;
            }else {
                nums[i] = 2;
            }
        }
    }
}
