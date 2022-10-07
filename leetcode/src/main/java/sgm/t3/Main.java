package sgm.t3;

import java.util.HashMap;
import java.util.Map;

/*
题名：3. 无重复字符的最长子串
链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/
题目：给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        //如果s长度为空直接返回
        if (s.length() == 0) return 0;
        //定义变量
        int left = 0;//无重复字符的起点
        int max = 0;//最长无重复字符数
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);//获取字符串第i个位置的字符
            if (map.containsKey(c)) {
                /*
                    s = abccb
                    一直到第一个c left = 0，第二个c的时候 left = get(c)+1=3
                    执行到第二个b前 left = 3，然后 left = max(left, get(b))=max(3, 2)
                 */
                left = Math.max(left, map.get(c)+1);//修改起点（滑动）
            }
            map.put(c, i);//添加进map
            max = Math.max(max, i-left+1);
        }
        return max;
    }
 }
