package leetcode.a800;

import java.util.Arrays;

/**
 * 字符串数组所能形成的最短后缀特征串\
 * {trie}
 */
public class _820Solution {

    /**
     * 先按从长到短进行排序，然后将字符串逆序往Trie树里面插入
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String word : words) {
            len += trie.insert(word);
        }
        return len;
    }

    // 定义tire
    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public int insert(String word) {
            TrieNode cur = root;
            boolean isNew = false;
            // 倒着插入单词
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    isNew = true; // 是新单词
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            // 如果是新单词的话编码长度增加新单词的长度+1，否则不变。
            return isNew ? word.length() + 1 : 0;
        }
    }

    class TrieNode {
        char val;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }
    }
}
