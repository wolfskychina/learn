package leetcode.a2000;

import java.util.HashSet;
import java.util.Set;
/**
 * 最多的字符串配对的数目
 * {easy}
 */
public class _2744Solution {
   
    public int maximumNumberOfStringPairs(String[] words) {

        Set<String> set = new HashSet<>();
        int count =0;
        for(String str:words){

            String re = reverse(str);
            if(set.contains(re)){
                count++;
                set.remove(re);
            }else{
                set.add(str);
            }

        }

        return count;
    }

    private String reverse(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
