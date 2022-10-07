package t8_greedy;

//单词查找树节点
class TrieNode {
    public int pass;//记录有多少字符被加入
    public int end;//记录以当前节点为结束的数量
    /*
        next[0] == null 表示a不存在
        next[0] != null 表示a存在
        ....
     */
    public TrieNode[] nexts = new TrieNode[26];//每个下标代表一个字母

}
class Trie {
    private static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static void insertWord(String word) {
        if (word == null || word.length() == 0)
            return;
        char[] chas = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (char cha : chas) {//遍历字符
            index = cha-'a';//确定索引
            if (node.nexts[index] == null){//是否存在路，不存在就创建通往这条路的节点
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];//节点下移
            node.pass++;
        }
        node.end++;
    }
    //查询单词被添加过几次
    public static int search(String word) {
        if (word == null)
            return 0;
        TrieNode node = root;
        int index = 0;
        for (char c : word.toCharArray()) {
            index = c - 'a';
            if (node.nexts[index] == null) {//没有下面的路了
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    //有多少单词以pre为前缀的
    public static int prefixNum(String pre) {
        if (pre == null)
            return 0;
        TrieNode node = root;
        int index = 0;
        for (char c : pre.toCharArray()) {
            index = c - 'a';
            if (node.nexts[index] == null) {//没有下面的路了
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }

    public static void delete(String word) {
        if (search(word)!=0) {//这个单词存在才删除
            char[] chas = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            node.pass--;
            for (char cha : chas) {
                index = cha - 'a';
                if (--node.nexts[index].pass == 0) {//说明这条树枝就只有这一个单词，直接置空就行
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }
}
public class Code1_TrieNode {


}


