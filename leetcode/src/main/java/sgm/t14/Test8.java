package sgm.t14;
/*
题目：字符串轮转

链接：https://leetcode.cn/problems/string-rotation-lcci/

要求：字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。


 s1：waterbottlewaterbottle   s2：erbottlewat
 */
public class Test8 {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1+s1).contains(s2);
    }
}
