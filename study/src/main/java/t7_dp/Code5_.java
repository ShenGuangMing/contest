package t7_dp;


import java.util.HashMap;

public class Code5_ {

    public static int minSticker3(String[] stickers, String target) {
        int[][] s = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                s[i][c-'a']++;
            }
        }
        HashMap<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        System.out.println(target);
        int ans = process3(s, target, dp);
        return ans == Integer.MAX_VALUE ? -1: ans;
    }
    public static int process3(int[][] stickers, String t, HashMap<String, Integer> dp) {
        if (dp.containsKey(t)) {
            return dp.get(t);
        }
        if (t.length() == 0)//目标字符已经剪完了，没有花一张剪纸
            return 0;
        char[] chars = t.toCharArray();
        int[] count = new int[26];//需要剪的词频表
        for (char c : chars) {
            count[c-'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stickers.length; i++) {
            int[] sticker = stickers[i];
            if (sticker[chars[0]-'a'] > 0) {//这张表有目标字符的第一个，才开始剪
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 26; j++) {//遍历目标统计表
                    if (count[j] > 0) {//目标需要才剪
                        int rest = count[j] - sticker[j];//当前词频的剩余次数
                        for (int k = 0; k < rest; k++) {
                            sb.append((char) ('a'+j));//添加第几个词频
                        }
                    }
                }
                //最小的就是我当前最小值和我剩下的拿去剪中的最小值
                min = Math.min(min, process3(stickers, sb.toString(), dp));
            }
        }
        int ans = min + (min == Integer.MAX_VALUE? 0 : 1);
        dp.put(t, ans);//入表
        return ans;
    }
    public static int minSticker2(String[] stickers, String target) {
        int[][] s = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                s[i][c-'a']++;
            }
        }
        int ans = process2(s, target);
        return ans == Integer.MAX_VALUE? -1: ans ;
    }
    public static int process2(int[][] arr, String target) {
        if (target.length() == 0) {
            return 0;
        }
        char[] c = target.toCharArray();
        int[] count = new int[26];
        for (char c1 : c) {
            count[c1-'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int[] sticker = arr[i];
            if (sticker[c[0] - 'a'] > 0) {//我的当前贴纸有target的第一个字符才跑
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (count[j] > 0){//大于0才需要剪
                        int num = count[j] - sticker[j];
                        for (int n = 0; n<num; n++) {
                            sb.append((char)('a'+j));
                        }
                    }
                }
                String s = sb.toString();
                min = Math.min(min, process2(arr, s));
            }
        }
        return min + (min ==  Integer.MAX_VALUE? 0 : 1);
    }


    public static int minSticker1(String[] stickers, String target) {
        return process1( stickers,  target);
    }
    public static int process1(String[] stickers, String target) {
        if (target.length() == 0) {//剪完了返回0，花了0张剪纸
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String sticker : stickers) {
            String rest = minus(target, sticker);//拿着剪纸去剪，返回还剩那些字符没有
            if (rest.length() != target.length()) {//要剪了至少一个字母，不然就下一个
                min = Math.min(min, process1(stickers, rest));
            }
        }
        //不是最大值就是剪成功了，自己用的这张也要算，不成功还是返回最大值
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    private static String minus(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[] count = new int[26];
        for (char c : str1) {
            count[c-'a']++;
        }
        for (char c : str2) {
            count[c-'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    sb.append((char)(i+'a'));
                }
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String[] arr = {"these","guess","about","garden","him"};
        System.out.println(minSticker2(arr, "atomher"));
        System.out.println(minSticker3(arr, "atomher"));
    }
}
