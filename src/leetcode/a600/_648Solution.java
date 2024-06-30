package leetcode.a600;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词用最短的词根替换
 * {trie}
 */
public class _648Solution {

    /**
     * 将词典表整理成词根表，同前缀词根只保留最短的值
     * 每个单词去词根里面遍历匹配
     * 比较慢
     * 
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {

        Collections.sort(dictionary, (o1, o2) -> o1.length() - o2.length());
        Set<String> set = new HashSet<>();
        for (String str : dictionary) {

            boolean ifContain = false;
            for (String s : set) {
                if (str.startsWith(s)) {
                    ifContain = true;
                    break;
                }
            }
            if (!ifContain) {
                set.add(str);
            }

        }

        String[] sen = sentence.split(" ");
        for (int i = 0; i < sen.length; i++) {

            for (String root : set) {

                if (sen[i].startsWith(root)) {
                    sen[i] = root;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sen.length; i++) {
            sb.append(sen[i]).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void add(String word) {
            if (word == null) {
                return;
            }
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if (node.children[cur - 'a'] == null) {
                    node.children[cur - 'a'] = new TrieNode();
                }
                node = node.children[cur - 'a'];
            }
            node.isWord = true;
        }

        public String convert(String word) {
            TrieNode node = root;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if (node.children[cur - 'a'] == null) {
                    break;
                }
                node = node.children[cur - 'a'];
                sb.append(cur);
                if (node.isWord) {
                    return sb.toString();
                }
            }
            return word;
        }

    }

    /**
     * {trie}树，更快
     * @param dict
     * @param sentence
     * @return
     */
    public String replaceWords1(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.add(word);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(trie.convert(word) + " ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
