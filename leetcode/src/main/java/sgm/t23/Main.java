package sgm.t23;
/*
* link:https://leetcode.cn/problems/simplify-path/description/
* */

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.simplifyPath("/.."));
//        System.out.println(1);
    }
    public String simplifyPath(String path) {
        String[] split = path.split("/");//剪切
        int index = 0;
        for (String s : split) {
            if (s.equals("") || s.equals(".")) {//遇到.和空格跳过
                continue;
            }
            if (s.equals("..")) {
                if (index <= 0) {//如果当前位置在0就跳过
                    continue;
                }
                split[--index] = s;//位置前移
                continue;
            }
            split[index++] = s;//正常添加
        }
        if (index <= 0) {//如果index位置等于0，就返回/
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<index; i++) {
            sb.append("/");
            sb.append(split[i]);
        }
        return sb.toString();
    }
}
