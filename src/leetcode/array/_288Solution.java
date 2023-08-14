package leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 判断一个类似k8s的字符串是不是在字典中唯一的
 */
public class _288Solution {

    public ValidWordAbbr abbr;

    public _288Solution(String[] dict){
        abbr = new ValidWordAbbr(dict); 
    }

    public class ValidWordAbbr {

        private Map<String, Set<String>> dict;

        public ValidWordAbbr(String[] dictionary) {
            // need a map<String, Set<String>> struc, first String is the ab of the word,
            // and second is the set contains all words that have the same ab.
            dict = new HashMap<String, Set<String>>();
            for (String str : dictionary) {

                String ab = getAbbrevation(str);
                if (dict.containsKey(ab)) {
                    Set set = dict.get(ab);
                    if (set.contains(str))
                        continue;
                    set.add(str);

                } else {
                    Set<String> set = new HashSet<String>();
                    set.add(str);
                    dict.put(ab, set);

                }

            }

        }

        private String getAbbrevation(String str) {
            if (str.length() <= 2) {
                return str;
            } else {
                return "" + str.substring(0, 1) + (str.length() - 2) + str.substring(str.length() - 1);
            }
        }

        public boolean isUnique(String word) {

            String ab = this.getAbbrevation(word);

            if (!dict.containsKey(ab))
                return true;

            if (dict.get(ab).size() ==1&&dict.get(ab).contains(word))
                return true;

            return false;

        }
    }

    public static void main(String[] args){
        String[] dictionary = {"deer","door","cake","card"};
        _288Solution so = new _288Solution(dictionary);
        System.out.println(so.abbr.isUnique("door"));
        System.out.println(so.abbr.isUnique("cart"));
        System.out.println(so.abbr.isUnique("card"));


    }
}
