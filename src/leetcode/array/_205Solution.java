package leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 判断两个字符串是不是可映射的
 * s中的两个不同字符不能映射到同一个字符
 */
public class _205Solution {

    public boolean isIsomorphic(String s, String t) {

        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(s.length() != t.length()) return false;

        Map<Character, Character> map  = new HashMap<>();
        Set<Character> set = new HashSet<>();

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for(int i=0; i<sChar.length; i++){

            if(map.containsKey(sChar[i])){

                if(map.get(sChar[i])!=tChar[i]) return false;
            }else{

                if(set.contains(tChar[i])) return false;

                map.put(sChar[i], tChar[i]);
                set.add(tChar[i]);
            }
        }

        return true;

    }
}
