package util;

public class StrUtil {
    public static String delStrPrefix(String s, char c) {
        String res = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != c) {
                res = s.substring(i);
                break;
            }
        }
        return res;
    }
}
