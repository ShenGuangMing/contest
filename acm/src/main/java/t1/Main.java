package t1;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 * 网站：https://leetcode.cn/problems/climbing-stairs/
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.otherMethod1(10));
        System.out.println(main.climbStairs(10));
    }
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.get(n) != null) return map.get(n);
        else  {
            int i = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, i);
            return i;
        }
    }
    public int otherMethod1(int n) {
        if (n == 1) return 1;//如果是一层只有一种结果
        if (n == 2) return 2;//如果有二层只有两种结果
        int l = 1;//低1层的情况数
        int r = 2;//第2层的情况数
        int result = 0;
        for (int i = 0; i < (n - 2); i++) {
            result = l +r;//第i本层的情况数
            l = r;//i-2层的情况数
            r = result;//i-1层的情况数
        }
        return result;
    }
}
