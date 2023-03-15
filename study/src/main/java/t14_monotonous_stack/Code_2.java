package t14_monotonous_stack;

import util.ArrayUtil;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 在一个数组中，找到每个数的左边第一个比它大的数和右边第一个比它大的数
 * 数组：可重复数字
 *
 */
public class Code_2 {
    public static void main(String[] args) {
        Code_2 code2 = new Code_2();
        int[] nums = {3, 2, 4, 4, 2, 3, 6};
        int[][] res = code2.findTheFirstLargeLeftAndRight(nums);
        ArrayUtil.print2Arr(res);
    }
    public int[][] findTheFirstLargeLeftAndRight(int[] nums) {
        Stack<LinkedList<Integer>> stack = new Stack<>();
        int[][] res = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek().getLast()]) {//栈不为空，且当前数大于了栈中的数
                LinkedList<Integer> stackTopLinked = stack.pop();//拿出栈顶链表
                //把链表拉出来
                for (Integer index : stackTopLinked) {//遍历栈顶列表
                    res[index][0] = stack.isEmpty() ? -1 : nums[stack.peek().getLast()];//比自己小的数是自己下面链表的尾节点
                    res[index][1] = nums[i];
                }
            }
            if (!stack.isEmpty() && nums[i] == nums[stack.peek().getLast()]) {//如果值相等就添加到栈顶链表的next
                stack.peek().addLast(i);
            } else {
                LinkedList<Integer> newLink = new LinkedList<>();
                newLink.addLast(i);
                stack.add(newLink);
            }
        }
        //处理余下的数据
        LinkedList<Integer> last = null;
        while (!stack.isEmpty()) {
            LinkedList<Integer> stackTop = stack.pop();
            for (Integer index : stackTop) {
                res[index][1] = last == null ? -1 : nums[last.getFirst()];
                res[index][0] =  stack.isEmpty() ? -1 : nums[stack.peek().getLast()];
            }
            last = stackTop;
        }
        return res;
    }
}
