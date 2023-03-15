package t14_monotonous_stack;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 在一个数组中，找到每个数的左边第一个比它大的数和右边第一个比它大的数
 * 数组：无重复数字
 *
 */
public class Code_1 {
    public static void main(String[] args) {
        Code_1 code_1 = new Code_1();
        int[] nums = {1, 2, 5, 4, 3, 7};
        int[][] res = code_1.findTheFirstLargeLeftAndRight(nums);
        ArrayUtil.print2Arr(res);
    }
    public int[][] findTheFirstLargeLeftAndRight(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[][] res = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                Integer stackTop = stack.pop();
                res[stackTop][0] = stack.isEmpty() ? -1 : nums[stack.peek()];
                res[stackTop][1] = nums[i];
            }
            stack.add(i);
        }
        int last = -1;
        while (!stack.isEmpty()) {
            Integer stackTop = stack.pop();
            res[stackTop][1] = last == -1 ? -1 : nums[last];
            res[stackTop][0] = stack.isEmpty() ? -1 : nums[stack.peek()];
            last = stackTop;
        }
        return res;
    }

}
