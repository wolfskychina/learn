package leetcode.a0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _30Solution {

    public List<Integer> findSubstring(String s, String[] words){
        final Map<String, Integer> counts = new HashMap<>();
        for(final String word:words){
            counts.put(word, counts.getOrDefault(word,0) +1);
        }
        final List<Integer> indexes = new ArrayList<>();
        if(words == null) return null;
        if(words.length ==0 ) return indexes;
        final int n = s.length();
        int num = words.length;
        int len = words[0].length();
        for(int i = 0;i<n-num*len+1;i++){
            final Map<String, Integer> seen = new HashMap<>();
            int j =0;
            while(j<num){
                final String word = s.substring(i +j*len, i+(j+1)*len);
                if(counts.containsKey(word)){
                    // 存在匹配的情况下还要看出现的次数是否和字符串数组中的一样
                    seen.put(word, seen.getOrDefault(word, 0)+1);
                    if(seen.get(word)>counts.getOrDefault(word,0)) break;
                }else{
                    break;
                }
                j++;
            }
            if(j==num) indexes.add(i);
        }

        return indexes;

    }
}
