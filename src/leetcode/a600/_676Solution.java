package leetcode.a600;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * 神奇字典
 * 给定一系列单词组成的词典，判断一个新单词能否只改变一个字符后和字典中的单词相同
 * {design}
 */
public class _676Solution {

    /**
     * 想的过于复杂。。。
     */
    class MagicDictionary {

        Map<Set<String>, Set<String>> map;

        public MagicDictionary() {
            map = new HashMap<>();

        }

        public void buildDict(String[] dictionary) {

            for (String str : dictionary) {

                Set<String> set = new HashSet<>();
                for (int i = 0; i < str.length(); i++) {
                    set.add(str.substring(0, i) + "*" + str.substring(i + 1));
                }
                Set<String> oriSet = map.getOrDefault(set, new HashSet<>());
                oriSet.add(str);
                map.put(set, oriSet);
            }

        }

        public boolean search(String searchWord) {

            for (int i = 0; i < searchWord.length(); i++) {
                String tar = searchWord.substring(0, i) + "*" + (searchWord.substring(i + 1));
                for (Set<String> set : map.keySet()) {

                    if (set.contains(tar)) {

                        Set<String> oriSet = map.get(set);
                        for (String oriStr : oriSet) {
                            if (!searchWord.equals(oriStr))
                                return true;
                        }
                    }
                }
            }

            return false;

        }
    }

    /**
     * 简单直接匹配
     */
    class MagicDictionary1 {
        private String[] words;

        /** Initialize your data structure here. */
        public MagicDictionary1() {

        }

        public void buildDict(String[] dictionary) {
            words = dictionary;
        }

        public boolean search(String searchWord) {
            for (String word : words) {
                if (word.length() != searchWord.length()) {
                    continue;
                }
                int diff = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != searchWord.charAt(i)) {
                        diff++;
                    }
                    if (diff > 1) {
                        break;
                    }
                }
                if (diff == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * {Trie}使用trie树保存，适合字典比较大的情况
     * 在查找的时候增加特殊逻辑，必须修改过一次字符才行
     */
    class MagicDictionary2 {
        Trie root;

        public MagicDictionary2() {
            root = new Trie();
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                Trie cur = root;
                for (int i = 0; i < word.length(); ++i) {
                    char ch = word.charAt(i);
                    int idx = ch - 'a';
                    if (cur.child[idx] == null) {
                        cur.child[idx] = new Trie();
                    }
                    cur = cur.child[idx];
                }
                cur.isFinished = true;
            }
        }

        public boolean search(String searchWord) {
            return dfs(searchWord, root, 0, false);
        }

        private boolean dfs(String searchWord, Trie node, int pos, boolean modified) {
            if (pos == searchWord.length()) {
                // 查找到的条件：必须要修改过一次
                return modified && node.isFinished;
            }
            int idx = searchWord.charAt(pos) - 'a';
            if (node.child[idx] != null) {
                if (dfs(searchWord, node.child[idx], pos + 1, modified)) {
                    return true;
                }
            }
            if (!modified) {
                for (int i = 0; i < 26; ++i) {
                    if (i != idx && node.child[i] != null) {
                        if (dfs(searchWord, node.child[i], pos + 1, true)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    class Trie {
        boolean isFinished;
        Trie[] child;

        public Trie() {
            isFinished = false;
            child = new Trie[26];
        }
    }
}
