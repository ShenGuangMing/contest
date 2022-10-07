package sgm.t16;

import sgm.util.ArrayUtil;

import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
//        int[] arr = {4,2,0,3,2,5};
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
        System.out.println(trap1(arr));
    }

    public static int trap1(int[] height) {
        int[][] arr = process2(height);
        int area = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] > 0 && arr[i][1] > 0) {
                int l = arr[i][0] - 1;
                int r = arr[i][1] - 1;
                int min = Math.min(height[l], height[r]);
                area += (min - height[i]) * (r - l - 1);
            }
        }
        return area;
    }


    public static int[][] process2(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int[][] m = new int[height.length][2];
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i + 1);
            } else if (height[stack.peek() - 1] > height[i]) {
                stack.push(i + 1);
            } else {
                int topIndex = stack.peek();//获取栈顶，不移除
                while (!stack.isEmpty() && height[topIndex - 1] <= height[i]) {
                    int pop = stack.pop();//弹出当前栈顶
                    m[pop - 1][1] = i + 1;//
                    if (!stack.isEmpty()) {//存在左边比自己大的
                        topIndex = stack.peek();
                        m[pop - 1][0] = topIndex;
                    }
                }
                stack.push(i + 1);
            }
        }

        return m;
    }

    public static int trap(int[] height) {
        int[][] arr = process1(height);
        int area = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] >= 0 && arr[i][1] >= 0) {
                int l = arr[i][0];
                int r = arr[i][1];
                int min = Math.min(height[l], height[r]);
                area += (min - height[i]) * (r - l - 1);
            }
        }
        return area;
    }

    public static int[][] process1(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int[][] m = new int[height.length][2];
        ArrayUtil.fill(m, -2);
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (height[stack.peek()] > height[i]) {
                stack.push(i);
            } else {
                int topIndex = stack.peek();//获取栈顶，不移除
                while (!stack.isEmpty() && height[topIndex] <= height[i]) {
                    int pop = stack.pop();//弹出当前栈顶
                    m[pop][1] = i;//
                    if (!stack.isEmpty()) {//存在左边比自己大的
                        topIndex = stack.peek();
                        m[pop][0] = topIndex;
                    }
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            m[stack.pop()][0] = -2;
        }
        return m;
    }
}
