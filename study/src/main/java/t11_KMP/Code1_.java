package t11_KMP;

public class Code1_ {

    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || s.length() < 1 || m.length() < 1) {
            return -1;
        }
        char[] s1 = s.toCharArray();
        char[] s2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(s2);
        while (i1 < s1.length && i2 < m.length()) {
            if (s1[i1] == s2[i2]){
                i1++;
                i2++;
            }else if (i2 == 0) {
                i1++;//换一个开头
            }else {
                i2=next[i2];
            }
        }
        return i2 == m.length() ? i1 - i2 : -1;
    }

    private static int[] getNextArray(char[] s2) {
        if (s2.length == 1){
            return new int[] {-1};
        }
        int[] next= new int[s2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < s2.length) {
            if (s2[i-1] == s2[cn]) {
                next[i++] = ++cn;
            }else if (cn > 0) {
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
