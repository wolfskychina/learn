package leetcode.a800;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 两个字符串中的不常见单词
 * {easy}
 */
public class _884Solution {
   
    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> setmuti = new HashSet<>();
        List<String> res = new ArrayList<>();

        for(String str:s1.split(" ")){
            if(!set1.add(str))
                setmuti.add(str);
        }

        for(String str:s2.split(" ")){
            if(!set2.add(str))
                setmuti.add(str);
        }

        for(String str:set1){
            if(!set2.contains(str)&&!setmuti.contains(str))
                res.add(str);
        }
        for(String str:set2){
                 if(!set1.contains(str)&&!setmuti.contains(str))
                res.add(str);
        }

        return res.toArray(new String[res.size()]);
    }
}
