package sgm.t14;

import java.util.ArrayList;
import java.util.List;
/*
题目：括号生成

链接：https://leetcode.cn/problems/generate-parentheses/

要求：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Test5 {
    public static void main(String[] args) {

    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        process1(n, n, "", res);
        return res;
    }
    /*
    copy别人的优解，感觉是贪心
     */
    public static void process1(int l, int r, String cur, List<String> list ) {
        if (l == 0 && r == 0) {
            list.add(cur);
        }
        if (l > r) {
            return;
        }
        if (l > 0) {
            process1(l-1, r, cur+'(', list);
        }
        if (r > 0) {
            process1(l, r-1, cur+')', list);
        }
    }
}
