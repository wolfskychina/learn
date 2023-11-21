package leetcode.a600;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * 神奇字典
 * 给定一系列单词组成的词典，判断一个新单词能否只改变一个字符后和字典中的单词相同
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
     * Your MagicDictionary object will be instantiated and called as such:
     * MagicDictionary obj = new MagicDictionary();
     * obj.buildDict(dictionary);
     * boolean param_2 = obj.search(searchWord);
     */
}
