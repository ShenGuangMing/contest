package leetcode.leetcode0125;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("Zeus was deified, saw Suez."));
    }
    public boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        boolean flag = false;
        for (int i = 0, j = c.length-1; i < j; i++, j--) {
            while (i<j && !((c[i]>='a'&&c[i]<='z') || (c[i]>='A'&&c[i]<='Z') || (c[i]>='0'&&c[i]<='9'))) {
                i++;
            }
            while (i<j && !((c[j]>='a'&&c[j]<='z') || (c[j]>='A'&&c[j]<='Z') || (c[j]>='0'&&c[j]<='9'))) {
                j--;
            }
            System.out.println(c[i] + " : " + c[j]);
            if (!(c[i]+"").equalsIgnoreCase(c[j]+"")) {
                flag = true;
                break;
            }

        }
        return !flag;
    }
}
