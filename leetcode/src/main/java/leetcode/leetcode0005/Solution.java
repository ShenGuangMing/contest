package leetcode.leetcode0005;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("caad"));
    }
    public String longestPalindrome(String s) {
        int len = s.length() * 2 + 1;
        char[] str = new char[len];
        int[] mark = new int[len];
        for (int i = 0; i < s.length(); i++) {//处理成特殊字符串
            str[i*2+1] = s.charAt(i);
        }
        int R = -1, C = -1, max = 0, start = 0;
        for (int i = 0; i < len; i++) {
            //获取不用验证的长度
            mark[i] = i < R ? Math.min(mark[2*C-i], R-i) : 1;
            while(mark[i] + i < len && i - mark[i] >= 0) {//往外扩
                if (str[mark[i] + i] == str[i - mark[i]])
                    mark[i]++;
                else
                    break;
            }
            if (R < mark[i] + i) {//更新R和C
                R = mark[i] + i;
                C = i;
            }
            if (max < mark[i]) {
                start = i;
                max = mark[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start-max+1; i<=start+max-1; i++) {
            if (i%2 != 0) {
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }

}
