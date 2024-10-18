package leetcode.a1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 返回目标字符串所有前缀在字典树中的前三个匹配项
 * {trie},{sorting},{binary search}
 */
public class _1268Solution {

    class Trie {

        Trie[] list = new Trie[26];
        boolean ifWord;

        public void iniTrie(Trie tree, String[] words) {

            for (String word : words) {

                char[] w = word.toCharArray();
                int i = 0;
                Trie idx = tree;
                for (; i < w.length; i++) {

                    if (idx.list[w[i] - 'a'] == null) {
                        idx.list[w[i] - 'a'] = new Trie();
                    }
                    idx = idx.list[w[i] - 'a'];
                }
                idx.ifWord = true;

            }
        }

        /**
         * 自己写的没写完 
         * @param tree
         * @param prefix
         * @return
         */
        public static List<String> find3containprefix(Trie tree, String prefix) {
            List<String> res = new ArrayList<>();
            int found = 0;

            Trie p = tree;
            for (int i = 0; i < prefix.length(); i++) {

            }

            return res;

        }

    }

    Trie tree = new Trie();

    /**
     * @param products
     * @param searchWord
     * @return
     */
    public List<List<String>> suggestedProducts1(String[] products, String searchWord) {

        Trie tree = new Trie();
        tree.iniTrie(tree, products);
        List<List<String>> res = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {

            String prefix = searchWord.substring(0, i);
            res.add(Trie.find3containprefix(tree, prefix));
        }

        return res;
    }

    /**
     * 排序加二分查找
     * @param ps
     * @param w
     * @return
     */
    public List<List<String>> suggestedProducts(String[] ps, String w) {
        Arrays.sort(ps);
        int n = ps.length;
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < w.length(); i++) {
            String cur = w.substring(0, i + 1);
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (ps[mid].compareTo(cur) >= 0)
                    r = mid;
                else
                    l = mid + 1;
            }
            List<String> list = new ArrayList<>();
            if (ps[r].compareTo(cur) >= 0) {
                for (int j = r; j < Math.min(n , r + 3); j++) {
                    if (ps[j].length() < cur.length())
                        break;
                    if (!ps[j].substring(0, i + 1).equals(cur))
                        break;
                    list.add(ps[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
