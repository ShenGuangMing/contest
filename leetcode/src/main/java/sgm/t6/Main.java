package sgm.t6;

import java.util.Arrays;

/*
题目：移动零
链接：https://leetcode.cn/problems/move-zeroes/
要求：
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
注意：请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = {1, 0, 3, 0, 12};
        main.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num!=0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
