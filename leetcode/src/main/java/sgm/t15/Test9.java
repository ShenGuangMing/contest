package sgm.t15;

import java.util.*;

public class Test9 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String s = new String(cs);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            List<String> list = map.get(s);
            list.add(str);
            map.put(s, list);
        }
        return new ArrayList<>(map.values());
    }
}
