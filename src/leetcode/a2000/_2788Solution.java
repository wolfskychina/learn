package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;

/**
 * 按分隔符拆分字符串
 */
public class _2788Solution {
   
    /**
     * 
     * @param words
     * @param separator
     * @return
     */
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        String sp = "\\"+separator;
        List<String> list = new ArrayList<>();
        for(String str:words){
            
            for(String s:str.split(sp)){
                if(s.equals("")) continue;
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String [] args){
        _2788Solution so = new _2788Solution();
        List<String> words = new ArrayList<>();
        words.add("one.two.three");
        words.add("four.five");
        words.add("six");
        so.splitWordsBySeparator(words, '.');
    }
}
