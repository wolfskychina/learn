package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;
/**
 * 查找包含指定字符的字符串
 * {easy}
 */
public class _2492Solution {
   
    public List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> res = new ArrayList<>();

        for(int i=0;i<words.length;i++){

            if(words[i].indexOf(x)!=-1)
                res.add(i);
        }
        return res;
    }
}
