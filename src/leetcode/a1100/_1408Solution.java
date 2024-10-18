package leetcode.a1100;

import java.util.ArrayList;
import java.util.List;
/**
 * 数组中的字符串匹配
 */
public class _1408Solution {
   
    /**
     * {indexOf}
     * @param words
     * @return
     */
    public List<String> stringMatching(String[] words) {

        List<String> res = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){

                // TODO indexOf的用法
                if(i!=j&&words[j].indexOf(words[i])>=0){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
