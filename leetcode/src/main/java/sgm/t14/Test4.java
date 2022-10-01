package sgm.t14;
/*
题目：重新格式化电话号码

链接：https://leetcode.cn/problems/reformat-phone-number/

要求：给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。

请你按下述方式重新格式化电话号码。

首先，删除 所有的空格和破折号。
其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
2 个数字：单个含 2 个数字的块。
3 个数字：单个含 3 个数字的块。
4 个数字：两个分别含 2 个数字的块。
最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。

返回格式化后的电话号码。
 */
public class Test4 {
    public static void main(String[] args) {
        Test4 t = new Test4();
        System.out.println(t.reformatNumber("-123-123123"));
    }
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (char c : number.toCharArray()) {
            int n = c - '0';
            if (n>=0 && n <=9) {
                sb.append(n);
            }
        }
        int index = 0;
        int len = sb.length();
        StringBuilder ans = new StringBuilder();
        while (len > 0) {
            if (len > 4) {
                ans.append(sb.substring(index, index + 3)).append("-");
                len-=3;
                index+=3;
            }else {
                if (len == 4) {
                    ans.append(sb.substring(index, index + 2)).append("-").append(sb.substring(index+2, index+4));
                }else {
                    ans.append(sb.substring(index, index+len));
                }
                return ans.toString();
            }
        }
        return ans.toString();
    }
}
