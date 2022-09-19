package sgm.t4;

/*
题名：4. 寻找两个正序数组的中位数
链接：https://leetcode.cn/problems/median-of-two-sorted-arrays/
题目：给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。

 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.findMedianSortedArrays(new int[]{2, 3, 5}, new int[]{1, 4, 7, 9}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //数组总长度
        int len = nums1.length + nums2.length;
        //指针
        int left = -1;
        int right = -1;
        int aStart = 0;//nums1数组的下标索引
        int bStart = 0;//nums2数组的下标索引
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart<nums1.length && (bStart >= nums2.length || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            }else {
                right = nums2[bStart++];
            }
        }
        return len%2 == 0? (left+right)/2.0 : right;
    }
}
