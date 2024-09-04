package leetcode.a200;

/**
 * 实现查找字典，支持.符号的通配符查找
 * trie树对.符合特殊处理，递归调用查找
 * {trie}
 */
public class _211Solution {

    class WordDictionary {

        WordDictionary[] next = new WordDictionary[26];
        boolean tail = false;

        public WordDictionary() {

        }

        public void addWord(String word) {

            WordDictionary WordDictionary = this;

            for (char c : word.toCharArray()) {

                if (WordDictionary.next[c - 'a'] != null) {

                    WordDictionary = WordDictionary.next[c - 'a'];
                } else {
                    WordDictionary newN = new WordDictionary();
                    WordDictionary.next[c - 'a'] = newN;
                    WordDictionary = newN;
                }

            }

            WordDictionary.tail = true;

        }

        public boolean search(String word) {
            char[] w = word.toCharArray();
            WordDictionary index = this;
            for (int i = 0; i < w.length; i++) {

                if (w[i] != '.') {

                    if (index.next[w[i] - 'a'] == null) {
                        return false;
                    } else {

                        index = index.next[w[i] - 'a'];
                    }
                } else {
                    // boolean wres = false;
                    for (int j = 0; j < 26; j++) {
                        // 原逻辑全部解空间搜索，没有必要
                        //if (index.next[j] != null) {
                        //    wres |= index.next[j].search(word.substring(i + 1));
                        //}
                        // 可以剪枝
                        if(index.next[j].search(word.substring(i+1))){
                            return true;
                        }
                    }

                    return false;
                }

            }

            return index.tail;

        }
    }
}
