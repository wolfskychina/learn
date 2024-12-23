package leetcode.a1800;

/**
 * 设计Trie树
 * 支持插入，删除，统计前缀出现数量和单词出现数量
 * {design},{trie}
 */
public class _1804Solution {

    class Trie {

        int pnum;
        int wnum;

        Trie[] next;

        public Trie() {
            pnum = 1;
            next = new Trie[26];
        }

        public void insert(String word) {

            Trie p = this;
            for (char c : word.toCharArray()) {

                if (p.next[c - 'a'] == null) {
                    Trie node = new Trie();
                    p.next[c - 'a'] = node;
                    p = p.next[c - 'a'];
                } else {
                    p.next[c - 'a'].pnum++;
                    p = p.next[c - 'a'];
                }

            }
            p.wnum++;

        }

        public int countWordsEqualTo(String word) {

            Trie p = this;
            for (char c : word.toCharArray()) {

                if (p.next[c - 'a'] == null) {
                    return 0;
                } else {
                    p = p.next[c - 'a'];
                }
            }
            return p.wnum;
        }

        public int countWordsStartingWith(String prefix) {

            Trie p = this;
            for (char c : prefix.toCharArray()) {

                if (p.next[c - 'a'] == null) {
                    return 0;
                } else {
                    p = p.next[c - 'a'];
                }
            }
            return p.pnum;
        }

        public void erase(String word) {

            Trie p = this;
            for (char c : word.toCharArray()) {

                if (p.next[c - 'a'] == null) {
                    return;
                } else {
                    p.next[c - 'a'].pnum--;
                    p = p.next[c - 'a'];
                }
            }
            p.wnum--;

        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * int param_2 = obj.countWordsEqualTo(word);
     * int param_3 = obj.countWordsStartingWith(prefix);
     * obj.erase(word);
     */
}
