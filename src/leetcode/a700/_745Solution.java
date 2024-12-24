package leetcode.a700;

import java.util.ArrayList;
import java.util.List;

/**
 * 前缀和后缀搜索
 * 
 */
public class _745Solution {

    class WordFilter {

        Trie ptree;
        Trie stree;

        public WordFilter(String[] words) {

            ptree = new Trie();
            stree = new Trie();
            for (int i = 0; i < words.length; i++) {
                ptree.insert(words[i], i);
                stree.rinsert(words[i], i);
            }

        }

        public int f(String pref, String suff) {

            List<Integer> l1 = ptree.query(pref);
            List<Integer> l2 = stree.query(suff);
            if (l1 == null || l2 == null)
                return -1;
            int i = l1.size() - 1;
            int j = l2.size() - 1;
            while (i >= 0 && j >= 0) {
                // TODO Integer不能直接比大小
                if (l1.get(i).compareTo(l2.get(j))==0) {
                    return l1.get(i);
                } else if (l1.get(i) > l2.get(j)) {
                    i--;
                } else {
                    j--;
                }
            }
            return -1;
        }

        class Trie {

            List<Integer> list;
            Trie[] next;

            public Trie() {
                list = new ArrayList<>();
                next = new Trie[26];
            }

            void insert(String s, int i) {
                Trie p = this;
                for (char c : s.toCharArray()) {

                    if (p.next[c - 'a'] == null) {
                        Trie node = new Trie();
                        p.next[c - 'a'] = node;
                    }
                    p.next[c - 'a'].list.add(i);

                    p = p.next[c - 'a'];

                }

            }

            void rinsert(String s, int idx) {
                Trie p = this;
                char[] ss = s.toCharArray();
                for (int i = ss.length - 1; i >= 0; i--) {

                    if (p.next[ss[i] - 'a'] == null) {
                        Trie node = new Trie();
                        p.next[ss[i] - 'a'] = node;
                    }
                    p.next[ss[i]-'a'].list.add(idx);
                    p = p.next[ss[i] - 'a'];

                }
            }

            public List<Integer> query(String s) {

                Trie p = this;
                for (char c : s.toCharArray()) {

                    if (p.next[c - 'a'] == null)
                        return null;
                    else
                        p = p.next[c - 'a'];

                }
                return p.list;
            }
        }
    }

    public static void main(String [] args){
        String[] words = {"abbba","abba"};
        _745Solution so = new _745Solution();
        WordFilter wf = so.new WordFilter(words);
        wf.f("ab","ba");
    }
}
