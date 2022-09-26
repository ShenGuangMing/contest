package sgm.t5;

import java.util.Arrays;

/*
题名：88. 合并两个有序数组
链接：https://leetcode.cn/problems/merge-sorted-array/
题目：给你两个按 非递减顺序 排列的整数数组nums1 和 nums2 另有两个整数 m 和 n ，分别表示 nums1 和 nums2
中的元素数目。请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，
nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        main.merge(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int aPoint = m-1;//nums1尾指针
        int bPoint = n-1;//nums2尾指针
        int putPoint = nums1.length-1;
        for (;putPoint >= 0; putPoint--) {
            if (aPoint >= 0 && (bPoint < 0 || nums1[aPoint] > nums2[bPoint])) {
                nums1[putPoint] = nums1[aPoint--];
            }else if(bPoint >= 0){
                nums1[putPoint] = nums2[bPoint--];
            }
        }
    }
}
