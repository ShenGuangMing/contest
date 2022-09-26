package sgm.t7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
题目：找到数组中消失的数
链接：https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
要求：给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。

 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        int[] arr = {10,2,5,10,9,1,1,4,3,7};
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(main.findDisappearedNumbers1(arr));
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            nums[(num-1) % len]+= len;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len)
                list.add(i+1);
        }
        return list;
    }
    public List<Integer> findDisappearedNumbers1(int[] nums) {//速度慢
        for (int num : nums) {
            if (num < 0)
                num*=-1;
            if (nums[num-1]> 0)
                nums[num-1] *= -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >  0)
                list.add(i+1);
        }
        return list;
    }

}
