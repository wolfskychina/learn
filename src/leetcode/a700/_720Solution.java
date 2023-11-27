package leetcode.a700;

import java.util.TreeSet;

/**
 * 字典中所有前缀都能在字典中找到的最长的单词，相同长度输出字典序最前面的
 */
public class _720Solution {
    class Trie {
        int dept;
        String word;
        Trie[] list = new Trie[26];
    }

    /**
     * {trie}
     * @param words
     * @return
     */
    public String longestWord(String[] words) {

        int max = 0;
        String res = "";
        // 按照从短到长排序
        TreeSet<String> set = new TreeSet<>((s1, s2) -> s1.length()==s2.length()?s1.compareTo(s2):s1.length() - s2.length());
        for (String str : words) {
            set.add(str);
        }

        Trie tree = new Trie();
        tree.word = "head";
        // 构建trie树直到，没有能加入trie树的字符串为止
        while (true) {

            TreeSet<String> newset = new TreeSet<>((s1, s2) -> s1.length()==s2.length()?s1.compareTo(s2):s1.length() - s2.length());
            for (String str : set) {

                if (addtoTrie(tree, str)) {
                    if (str.length() > max) {
                        max = str.length();
                        res = str;
                    }
                } else {
                    newset.add(str);
                }

            }
            if (set.size() == newset.size())
                break;
            set = newset;
        }

        return res;

    }

    private boolean addtoTrie(Trie tree, String str) {

        int i=0;
        // TODO 注意trie树搜索的停止条件
        for(;i<str.length()-1;i++){
            tree = tree.list[str.charAt(i)-'a'];
            if(tree == null) break;
        }
        if(i==str.length()-1){
            Trie node = new Trie();
            node.word = str;
            tree.list[str.charAt(i)-'a'] = node;
            return true;
        }

        return false;
    }

    public static void main(String [] args){
        _720Solution so = new _720Solution();
        String [] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        so.longestWord(words);
    }
}
