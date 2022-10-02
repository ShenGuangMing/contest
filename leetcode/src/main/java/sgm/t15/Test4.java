package sgm.t15;


/*
题目：缺失的第一个正数

链接：https://leetcode.cn/problems/first-missing-positive/

要求：给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */

public class Test4 {

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(firstMissingPositive(arr));
    }
    public static int firstMissingPositive(int[] nums) {
        boolean isOne = false;
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            if (nums[i] == 1){
                isOne = true;
            } else if (nums[i] <= 0) {
                nums[i] = 1;
            }
        }
        if (!isOne)
            return 1;
        for (int i = 0; i < N; i++) {
            int index= Math.abs(nums[i]);
            if (index <= N && index >=1) {
                nums[index-1] = -Math.abs(nums[index-1]);
            }
        }
        for (int i = 0; i < N; i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        }
        return N+1;
    }
}
