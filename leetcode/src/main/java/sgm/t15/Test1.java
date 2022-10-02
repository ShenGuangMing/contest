package sgm.t15;
/*
题目：外观数列

链接：https://leetcode.cn/problems/count-and-say/

要求：给定一个正整数 n ，输出外观数列的第 n 项。

「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。

你可以将其视作是由递归公式定义的数字字符串序列：

countAndSay(1) = "1"
countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
第一项是数字 1
描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"

 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(countAndSay1(4));
    }
    public static String countAndSay1(int n) {
        if (n == 1)
            return "1";
        return process1(countAndSay1(n-1));
    }

    public static String process1(String s) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int len = cs.length;
        char prev = cs[0];
        for (int i = 1; i < len; i++) {
            if (cs[i] == prev) {
                count++;
            }else {
                sb.append(count).append(prev);
                prev = cs[i];
                count = 1;
            }
        }
        sb.append(count).append(prev);
        return sb.toString();
    }
    public static String countAndSay(int n) {
        if (n == 1)
            return "1";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int m = n%10;
        n/=10;
        while (n!=0) {
            int cur = n%10;
            if (cur == m) {
                count++;
            }else {
                sb.append(m).append(count);
                m = cur;
                count = 1;
            }
            n/=10;
        }
        sb.append(m).append(count);
        return sb.reverse().toString();
    }
}
