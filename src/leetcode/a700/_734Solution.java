package leetcode.a700;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 根据单词的相似性判断句子的相似性
 */
public class _734Solution {
  
    /**
     * {Hashset}根据set进行判断,比较慢
     * @param sentence1
     * @param sentence2
     * @param similarPairs
     * @return
     */
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {

        if(sentence1.length!=sentence2.length) return false;

        Set<String> set = new HashSet<>();
        for(List<String> list:similarPairs){
            set.add(list.get(0)+"+"+list.get(1));
        }

        for(int i=0;i<sentence1.length;i++){
            if(sentence1[i].equals(sentence2[i])) continue;
            if(!set.contains(sentence1[i]+"+"+sentence2[i])
            &&!set.contains(sentence2[i]+"+"+sentence1[i]))
                return false;
        }

        return true;
    }

    /**
     * {HashMap} 用hashmap快很多
     * @param sentence1
     * @param sentence2
     * @param similarPairs
     * @return
     */
    public boolean areSentencesSimilar1(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> pair : similarPairs) {
            String one = pair.get(0);
            String two = pair.get(1);
            map.putIfAbsent(one, new HashSet<>());
            map.get(one).add(two);
        }
        for (int i = 0; i < sentence1.length; i++) {
            String one = sentence1[i];
            String two = sentence2[i];
            if (one.equals(two)) {
                continue;
            }
            if (map.containsKey(one) && map.get(one).contains(two) || map.containsKey(two) && map.get(two).contains(one)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    
}
