package sgm.t15;
/*
题目：盛最多水的容器

链接：https://leetcode.cn/problems/container-with-most-water/

要求：给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。
 */
public class Test2 {
    public static void main(String[] args) {
        int[] h = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(h));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while (l<r) {
            int min = Math.min(height[l], height[r]);
            max = Math.max(max, min*(r-l));
            if (height[l] < height[r]) {//哪里小移动哪
                l++;
            }else {
                r--;
            }
        }
        return max;
    }
}
