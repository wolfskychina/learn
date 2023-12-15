package leetcode.a800;

import java.util.HashSet;
import java.util.Set;
/**
 * 统计数组中元音字符串的个数
 * {easy}
 */
public class _2586Solution {
   
    public int vowelStrings(String[] words, int left, int right) {

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count =0;
        for(int i=left;i<=right;i++){

            if(set.contains(words[i].charAt(0))&&
            set.contains(words[i].charAt(words[i].length()-1)))
                count++;
        }

        return count;

    }
}
