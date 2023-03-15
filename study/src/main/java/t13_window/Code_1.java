package t13_window;

import java.util.LinkedList;

public class Code_1 {
    public static int[] getMaxWindow(int[] nums, int w) {
        if (nums.length < 1 || w < 1 || w > nums.length) {//不满足的所有情况
            return null;
        }
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[nums.length - w + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!qMax.isEmpty() && nums[i] >= nums[qMax.peekLast()]) {//找到nums[i]进入的位置
                qMax.pollLast();
            }
            qMax.add(nums[i]);//添加到右边
            //过期下标
            if (qMax.peekFirst() == i - w) {
                qMax.pollFirst();
            }
            if (i >= w - 1) {//窗口形成
                res[index++] = nums[qMax.peekFirst()];
            }
        }
        return res;
    }
}
